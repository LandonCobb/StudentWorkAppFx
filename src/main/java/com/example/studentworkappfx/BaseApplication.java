package com.example.studentworkappfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BaseApplication extends Application {
    //App Dimensions should be 900x630px
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BaseApplication.class.getResource("Scheduler.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 630);
        stage.setTitle("Hello!");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}