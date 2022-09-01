package com.example.studentworkappfx;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

public class Clock implements Initializable {
    @FXML private Label lbCurrentTime;
    @FXML private Label lbSwTime;
    @FXML private Button btnSw;

    private boolean isStopwatchActive = false;
    private final Calendar swTime = Calendar.getInstance();

    @FXML public void onSWClick(ActionEvent event) {
        isStopwatchActive = !isStopwatchActive;
        if (isStopwatchActive) {
            btnSw.setStyle("-fx-background-color: #0c8004;");
        } else {
            btnSw.setStyle("-fx-background-color: #ff0000;");
        }
    }

    public static String getCurrentTime(){
        return new SimpleDateFormat("HH:mm:ss aaa", Locale.ENGLISH).format(Calendar.getInstance().getTime());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> {
            swTime.set(Calendar.HOUR, 12);
            swTime.set(Calendar.MINUTE, 0);
            swTime.set(Calendar.SECOND, 0);
            lbCurrentTime.setText(Clock.getCurrentTime());
        });

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
            lbCurrentTime.setText(Clock.getCurrentTime());
            if (isStopwatchActive) {
                swTime.add(Calendar.SECOND, 1);
                String swTimeStr = new SimpleDateFormat("HH:mm:ss", Locale.UK).format(swTime.getTime()); // Locale.UK is pretty much military time
                lbSwTime.setText(swTimeStr);
            }
        }));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }


}
