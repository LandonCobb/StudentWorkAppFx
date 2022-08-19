package com.example.studentworkappfx;

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

    private static String dd = "";
    @FXML
    protected void save() throws IOException {
        System.out.println(text.getText());
        dd = d.getText();
        writeToFile(text.getText());
        Slabel.setText("Saved");
    }

    public static void writeToFile(String existingLine) throws IOException {
        PrintStream out = new PrintStream(new FileOutputStream( "target/Notes/" + dd + ".txt", false));
        try {
            out.println(existingLine);
        } finally {
            out.close();
        }
    }

    @FXML
    protected void load() throws IOException {
        System.out.println(text.getText());
        dd = d.getText();
        readFile();
        Slabel.setText("Loaded");
    }

    public void readFile() throws IOException {
        InputStream fileIn = new FileInputStream("target/Notes/" + dd + ".txt");
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
