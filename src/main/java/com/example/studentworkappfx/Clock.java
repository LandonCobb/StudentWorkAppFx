package com.example.studentworkappfx;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import java.util.concurrent.TimeUnit;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class Clock implements Initializable {
    private int clickedCount = 0;
    private int swCount = 0;
    @FXML
    private Text clockText;

    @FXML
    private Button swButton;

    @FXML
    private Text swFinishText;

    @FXML
    public void onSWClick(MouseEvent mouseEvent) {
        clickedCount++;
        swButton.setStyle("-fx-background-color: #ff0000;");
        Timer timer = new Timer();
        if(clickedCount % 2 == 1){
            swCount = 0;
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    swCount++;
                    swFinishText.setText(Integer.toString(swCount));
                    if(clickedCount % 2 == 0){
                        timer.cancel();
                        swButton.setStyle("-fx-background-color: #00ff00;");
                        swFinishText.setText(Integer.toString(swCount - 1));
                    }
                }
            }, 0, 1000);
        }
    }

    public String getCurrentTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                clockText.setText(getCurrentTime());
            }
        }, 0, 1000);
    }


}
