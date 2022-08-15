package com.example.studentworkappfx;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.Scanner;


public class NoteController {
    @FXML
    private TextArea text;

    @FXML
    private TextField d;

    private static String dd = "";
    @FXML
    protected void save() throws IOException {
        System.out.println(text.getText());
        dd = d.getText();
        writeToFile(text.getText());
    }

    public static void writeToFile(String existingLine) throws IOException {
        PrintStream out = new PrintStream(new FileOutputStream( dd + ".txt", false));
        try {
            out.println(existingLine);
        } finally {
            //fileOut.flush();
            out.close();
        }
    }

    @FXML
    protected void load() throws IOException {
        System.out.println(text.getText());
        dd = d.getText();
        readFile();
    }

    public void readFile() throws IOException {
        InputStream fileIn = new FileInputStream(dd + ".txt");
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
