package cz.spsmb.xlesson.imageconvertor.controller;

import cz.spsmb.xlesson.imageconvertor.convertor.Convertor;
import cz.spsmb.xlesson.imageconvertor.convertor.MockConvertor;
import cz.spsmb.xlesson.imageconvertor.helper.ConvertImage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import org.reflections.Reflections;

import java.io.File;
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
    public ComboBox<String> convertors;

    private Map<String, Convertor> convertorMap;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Reflections reflections = new Reflections(PACKAGE_PREFIX);
        this.convertorMap = new HashMap<>();

        Set<Class<? extends Convertor>> allClasses =
                reflections.getSubTypesOf(Convertor.class);
        for (Class<? extends Convertor> subClass : allClasses) {
            try {
                Convertor instance = subClass.getDeclaredConstructor(null).newInstance();
                this.convertorMap.put(instance.getLabel(), instance);
                this.convertors.getItems().add(instance.getLabel());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(!convertorMap.isEmpty()) {
            convertors.getSelectionModel().selectFirst();
        }
    }

    public void loadLeftImage(MouseEvent mouseEvent) {
        Window window = ((Node) mouseEvent.getTarget()).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Chose Image");
        File chosenFile = fileChooser.showOpenDialog(window);
        Image image = new Image(chosenFile.toURI().toString());
        leftImage.setImage(image);
    }

    public void loadMidImage(MouseEvent mouseEvent) {
        Window window = ((Node) mouseEvent.getTarget()).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Chose Image");
        File chosenFile = fileChooser.showOpenDialog(window);
        Image image = new Image(chosenFile.toURI().toString());
        midImage.setImage(image);
    }

    public void convert() {
        Image leftImg = leftImage.getImage();
        Image rightImg = midImage.getImage();
        Convertor convolutionService = convertorMap.get(convertors.getSelectionModel().getSelectedItem());
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

        int[][][] img = convolutionService.compute(imageLeft, imageRight);
        Image convertedImg = ConvertImage.convertIntArrayToImg(leftImg, img);
        rightImage.setImage(convertedImg);
    }
}