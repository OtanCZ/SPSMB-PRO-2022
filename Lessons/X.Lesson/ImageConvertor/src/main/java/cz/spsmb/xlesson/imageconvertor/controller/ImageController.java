package cz.spsmb.xlesson.imageconvertor.controller;

import cz.spsmb.xlesson.imageconvertor.convertor.Convertor;
import cz.spsmb.xlesson.imageconvertor.helper.ConvertImage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import org.reflections.Reflections;

import java.io.File;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

public class ImageController implements Initializable {

    public static final String PACKAGE_PREFIX = "cz.spsmb";

    @FXML
    public ImageView leftImage;
    @FXML
    public ImageView midImage;
    @FXML
    public ImageView rightImage;
    @FXML
    public Label label;
    @FXML
    public ComboBox<String> convertors;

    private Map<String, Convertor> convertorMap;

    public ImageController() {
        this.convertorMap = new HashMap<>();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Reflections reflections = new Reflections(PACKAGE_PREFIX);
        Set<Class<? extends Convertor>> allClasses =
                reflections.getSubTypesOf(Convertor.class);
        for (Class<? extends Convertor> subClass : allClasses) {
            try {
                if (!Modifier.isAbstract(subClass.getModifiers())) {
                    Convertor instance = subClass.getDeclaredConstructor(null).newInstance();
                    this.convertorMap.put(instance.getLabel(), instance);
                    this.convertors.getItems().add(instance.getLabel());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(!convertorMap.isEmpty()) {
            convertors.getSelectionModel().selectFirst();
        }
        this.leftImage.setImage(new Image("./img/lake.jpg"));
        this.midImage.setImage(new Image("./img/road.jpg"));
    }

    public void loadLeftImage(MouseEvent mouseEvent) {
        File chosenFile = showChoseImageDialog(mouseEvent);
        if (chosenFile != null) {
            Image image = new Image(chosenFile.toURI().toString());
            leftImage.setImage(image);
        }
    }

    private File showChoseImageDialog(MouseEvent mouseEvent) {
        Window window = ((Node) mouseEvent.getTarget()).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Chose Image");
        return fileChooser.showOpenDialog(window);
    }

    public void loadMidImage(MouseEvent mouseEvent) {
        File chosenFile = showChoseImageDialog(mouseEvent);
        if (chosenFile != null) {
            Image image = new Image(chosenFile.toURI().toString());
            midImage.setImage(image);
        }
    }

    public void convert() {
        Convertor convertorService = convertorMap.get(convertors.getSelectionModel().getSelectedItem());
        cleanTextError();
        if (convertorService == null) {
            label.setText("Select convertor service");
            return;
        }
        try {
            Image leftImg = leftImage.getImage();
            Image rightImg = midImage.getImage();
            if(leftImg == null) {
                this.label.setText("Select left image");
            }
            if(rightImg == null) {
                this.label.setText("Select middle image");
            }
            if (leftImg.getWidth() == rightImg.getWidth() && leftImg.getHeight() == rightImg.getHeight()) {
                cz.spsmb.xlesson.imageconvertor.model.Image imageLeft = new cz.spsmb.xlesson.imageconvertor.model.Image() {
                    @Override
                    public int[][][] getArray() {
                        return ConvertImage.convertImageToIntArray(leftImg);
                    }
                };
                cz.spsmb.xlesson.imageconvertor.model.Image imageRight = new cz.spsmb.xlesson.imageconvertor.model.Image() {
                    @Override
                    public int[][][] getArray() {
                        return ConvertImage.convertImageToIntArray(rightImg);
                    }
                };

                int[][][] img = convertorService.compute(imageLeft, imageRight);
                Image convertedImg = ConvertImage.convertIntArrayToImg(leftImg, img);
                rightImage.setImage(convertedImg);
            } else {
                label.setText("Image size must be same.");
            }
        } catch (Exception e) {
            label.setText("Computation error: " + e.getMessage());
        }
    }

    private void cleanTextError() {
        this.label.setText("");
    }
}