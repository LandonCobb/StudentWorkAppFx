package com.example.studentworkappfx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.net.URL;


public class NoteController {
    @FXML
    private TextArea text;

    @FXML
    protected void save(){
        System.out.println(text.getText());
    }

}
