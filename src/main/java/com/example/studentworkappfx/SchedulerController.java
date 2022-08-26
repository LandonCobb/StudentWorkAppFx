package com.example.studentworkappfx;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class SchedulerController implements Initializable {
    @FXML private Text dPaneNumday;
    @FXML private Text dPaneWeekday;
    @FXML private Text txtChangeDate;
    @FXML private Spinner spnScheduleDAY;
    @FXML private Spinner spnScheduleMONTH;
    @FXML private Spinner spnScheduleYEAR;
    @FXML private Button btnSelectDate;
    @FXML private Button btnEditEvent;
    @FXML private Button btnAddEvent;
    @FXML private Button btnClearSchedule;

    @FXML private TableView<TimeTableEntry> timeTable;
    @FXML private TableColumn<TimeTableEntry, String> timeTableTimes;
    @FXML private TableColumn<TimeTableEntry, String> timeTableEvents;

    private static class Month {
        private final String name;
        private final int days;

        Month(String name, int days){
            this.name = name;
            this.days = days;
        }

        public String getName() {
            return name;
        }

        public int getDays() {
            return days;
        }
    }

    private final ObservableList<Month> months = FXCollections.observableArrayList(
            new Month("January", 30),
            new Month("February", 30),
            new Month("March", 30),
            new Month("April", 30),
            new Month("May", 30),
            new Month("June", 30),
            new Month("July", 30),
            new Month("August", 30),
            new Month("September", 30),
            new Month("October", 30),
            new Month("November", 30),
            new Month("December", 30)
    );

    private ObservableList<String> getMonthNames(ObservableList<Month> months) {
        List<String> monthNames;
        monthNames = new ArrayList<String>();

        months.forEach(month -> {
            System.out.println(month.getName());
            monthNames.add(month.getName());
        });

        return FXCollections.observableList(monthNames);
    }

    private ObservableList<String> monthName = getMonthNames(months);

    private final Map<String, Integer> monthInfo = new HashMap<>() {{
        this.put("January", 31);
        this.put("February", 28);
        this.put("March", 31);
        this.put("April", 30);
        this.put("May", 31);
        this.put("June", 30);
        this.put("July", 31);
        this.put("August", 31);
        this.put("September", 30);
        this.put("October", 31);
        this.put("November", 30);
        this.put("December", 31);
    }};

    private final ObservableList<TimeTableEntry> timeTableData = FXCollections.observableArrayList(
            new TimeTableEntry("6:00", ""),
            new TimeTableEntry("6:30", ""),
            new TimeTableEntry("7:00", ""),
            new TimeTableEntry("7:30", ""),
            new TimeTableEntry("8:00", ""),
            new TimeTableEntry("8:30", ""),
            new TimeTableEntry("9:00", ""),
            new TimeTableEntry("9:30", ""),
            new TimeTableEntry("10:00", ""),
            new TimeTableEntry("10:30", ""),
            new TimeTableEntry("11:00", ""),
            new TimeTableEntry("11:30", ""),
            new TimeTableEntry("12:00", ""),
            new TimeTableEntry("12:30", ""),
            new TimeTableEntry("1:00", ""),
            new TimeTableEntry("1:30", ""),
            new TimeTableEntry("2:00", ""),
            new TimeTableEntry("2:30", ""),
            new TimeTableEntry("3:00", ""),
            new TimeTableEntry("3:30", ""),
            new TimeTableEntry("4:30", ""),
            new TimeTableEntry("5:00", ""),
            new TimeTableEntry("5:30", ""),
            new TimeTableEntry("6:00", "")
    );

    private void setupDate() {
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
        SpinnerValueFactory<String> valueFactoryMonths = new SpinnerValueFactory.ListSpinnerValueFactory<String>(monthName);
        SpinnerValueFactory<Integer> valueFactoryDay = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 30, day);
        SpinnerValueFactory<Integer> valueFactoryYear = new SpinnerValueFactory.IntegerSpinnerValueFactory(year, year + 10, year);
        valueFactoryMonths.setValue(month);
        //TODO: Refactor line (this-3) with appropriate maximum day value for each month (possibly switch case)?.

        spnScheduleDAY.setValueFactory(valueFactoryDay);
        spnScheduleMONTH.setValueFactory(valueFactoryMonths);
        spnScheduleYEAR.setValueFactory(valueFactoryYear);
    }

    private void setupTimeTable() {
        timeTableTimes.setCellValueFactory(new PropertyValueFactory("time"));
        timeTableEvents.setCellValueFactory(new PropertyValueFactory("event"));
        timeTable.setItems(timeTableData);
        //timeTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        //timeTable.getColumns().addAll(timeTableTimes, timeTableEvents);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> {
            setupDate();
            setupTimeTable();
        });
    }

    private void syncDate() {

    }

    @FXML private void onSelectDate() {
        String day = spnScheduleDAY.getValue().toString();
        String month = spnScheduleMONTH.getValue().toString();
        String year = spnScheduleYEAR.getValue().toString();
        String date = day + "/" + month + "/" + year;

        System.out.println(date);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);
        System.out.println("!" + localDate.toString());
    }

    @FXML private void onEditEvent() {

    }

    @FXML private void onAddEvent() {

    }

    @FXML private void onClearSchedule() {

    }



}
