package com.example.studentworkappfx;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ChangeScene {

    private static Stage stage;
    private static Scene scene;

    public static void changeScene(Event event, String strFXMLFileName) throws IOException {
        URL url = new File("src/main/resources/com/example/StudentWorkAppFx/" + strFXMLFileName).toURI().toURL();
        Parent root = FXMLLoader.load(url);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void getModal(Event event, String strFXMLFileName, String title) throws IOException {
        URL url = new File("src/main/resources/com/example/StudentWorkAppFx/" + strFXMLFileName).toURI().toURL();
        Parent root = FXMLLoader.load(url);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        Stage modal = new Stage();
        modal.setTitle(title);
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.initOwner(stage);
        modal.setResizable(false);

        Scene modalScene = new Scene(root);
        modal.setScene(modalScene);
        modal.show();
    }
}
