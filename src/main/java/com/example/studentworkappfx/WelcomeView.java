package com.example.studentworkappfx;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WelcomeView{

    @FXML
    public AnchorPane anchorPane;

    @FXML
    public void onGSClicked(MouseEvent mouseEvent) throws IOException {
        ChangeScene.changeScene(mouseEvent, "Scheduler.fxml");
    }
}
