package cz.spsmb.xlesson.imageconvertor.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ImgConvertorLauncher extends Application {

    public static void start() {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ImgConvertorLauncher.class.getResource("image-convertor.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1600, 640);
        scene.getStylesheets().add(ImgConvertorLauncher.class.getResource("styleSheet.css").toString());
        stage.setTitle("Image convertor");
        stage.setScene(scene);
        stage.show();
    }
}