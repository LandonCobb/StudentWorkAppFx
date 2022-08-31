package com.example.studentworkappfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.Scanner;


public class NoteController {
    @FXML
    private TextArea text;

    @FXML
    private TextField d;

    @FXML
    private Label Slabel;
    @FXML
    protected void save() throws IOException {
        System.out.println(text.getText());
        writeToFile(text.getText());
        Slabel.setText("Saved");
    }

    public void writeToFile(String existingLine) throws IOException {
        PrintStream out = new PrintStream(new FileOutputStream( "target/Notes/" + d.getText() + ".txt", false));
        try {
            out.println(existingLine);
        } finally {
            out.close();
        }
    }

    @FXML
    protected void load() throws IOException {
        System.out.println(text.getText());
        readFile();
        Slabel.setText("Loaded");
    }

    public void readFile() throws IOException {
        InputStream fileIn = new FileInputStream("target/Notes/" + d.getText() + ".txt");
        BufferedReader in = new BufferedReader(new InputStreamReader(fileIn));
        String line = "";
        try{
            line = in.readLine();
            while(line != null){
                System.out.println(line);
                text.setText(line);
                line = in.readLine();
            }
        }finally {
            fileIn.close();
        }
    }
}
