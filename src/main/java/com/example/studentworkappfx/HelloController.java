package com.example.studentworkappfx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;


public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onGradeClick() {
        welcomeText.setText("Link to Canvas");
        // code below was made possible with the help of Stack overflow https://stackoverflow.com/questions/10967451/open-a-link-in-browser-with-java-button
        try {
            String url = "https://lms.neumont.edu"; // the url
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
            // goes to the desktop and searches the url through the main search engine
        } catch (java.io.IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    protected void onOrderClick() {
        welcomeText.setText("Link to Work Orders");

        try {
            String url = "https://my.neumont.edu/services/work-order";
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        } catch (java.io.IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    protected void onDegreeClick() {
        welcomeText.setText("Link to the Degree Website");

        try {
            String url = "https://degree.neumont.edu";
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        } catch (java.io.IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    protected void onTuitionClick() {
        welcomeText.setText("Link to Tuition Options");

        try {
            String url = "https://tuitionoptions.accountvue.com";
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        } catch (java.io.IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    protected void onStudentClick() {
        welcomeText.setText("Link to the Student Portal");

        try {
            String url = "https://portal.neumont.edu/secure/student/StuPortal.aspx";
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        } catch (java.io.IOException e) {
            System.out.println(e.getMessage());
        }
    }
}