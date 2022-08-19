package com.example.studentworkappfx;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class SchedulerController implements Initializable {
    @FXML private Text dPaneNumday;
    @FXML private Text dPaneWeekday;
    @FXML private Text txtChangeDate;
    @FXML private Spinner spnScheduleYEAR;
    @FXML private Spinner spnScheduleMONTH;
    @FXML private Spinner spnScheduleDAY;
    @FXML private Button btnSelectDate;
    @FXML private Button btnEditEvent;
    @FXML private Button btnAddEvent;
    @FXML private Button btnClearSchedule;

    private void setup() {
        LocalDate date = LocalDate.now();
        int day = date.getDayOfMonth();
        String month = String.valueOf(date.getMonth());
        int year = date.getYear();
        String weekday = String.valueOf(date.getDayOfWeek());

        // Formatting
        weekday = weekday.substring(0, 1).toUpperCase() + weekday.substring(1).toLowerCase();
        month = month.substring(0, 1).toUpperCase() + month.substring(1).toLowerCase();

        dPaneNumday.setText(String.valueOf(day));
        dPaneWeekday.setText(weekday);

        // The following code block is attributed to an unnamed contributor from "o7planning".
        // Site link: https://o7planning.org/11185/javafx-spinner

        ObservableList<String> months = FXCollections.observableArrayList(//
                "January", "February", "March", "April", //
                "May", "June", "July", "August", //
                "September", "October", "November", "December");

        SpinnerValueFactory<String> valueFactoryMonths = new SpinnerValueFactory.ListSpinnerValueFactory<String>(months);
        SpinnerValueFactory<Integer> valueFactoryDay = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 30, day);
        SpinnerValueFactory<Integer> valueFactoryYear = new SpinnerValueFactory.IntegerSpinnerValueFactory(year, year + 10, year);
        valueFactoryMonths.setValue(month);
        //TODO: Refactor line (this-3) with appropriate maximum day value for each month (possibly switch case)?.

        spnScheduleDAY.setValueFactory(valueFactoryDay);
        spnScheduleMONTH.setValueFactory(valueFactoryMonths);
        spnScheduleYEAR.setValueFactory(valueFactoryYear);

    }

    private void initSpinner() {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> {
            setup();
        });
    }
}
