package com.example.studentworkappfx;

import javafx.fxml.FXML;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class HomeController {

    @FXML
    protected void onStart(javafx.event.ActionEvent event) throws IOException {
        //btnHello.setText("Done!");
        ChangeScene.changeScene(event,  "Scheduler.fxml");
    }
}
