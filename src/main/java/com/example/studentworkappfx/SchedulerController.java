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
import java.text.SimpleDateFormat;
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

    public class TimeTableEntry {
        private String time;
        private String event;

        public TimeTableEntry(String time, String event) {
            this.time = time;
            this.event = event;
        }

        public String getTime() { return time; }
        public String getEvent() {
            return event;
        }
    }


    private final ObservableList<Month> months = FXCollections.observableArrayList(
            new Month("January", 31),
            new Month("February", 28),
            new Month("March", 31),
            new Month("April", 30),
            new Month("May", 31),
            new Month("June", 30),
            new Month("July", 31),
            new Month("August", 31),
            new Month("September", 30),
            new Month("October", 31),
            new Month("November", 30),
            new Month("December", 31)
    );

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

    private void testFunc() {
        Calendar c = Calendar.getInstance();
        var t = c.getTime().getYear();
        String d = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        System.out.println("@!@!" + d);
    }

    private void newSetupDate() {
        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);

        String weekday = new SimpleDateFormat("EEEE").format(c.getTime());
        System.out.println("newSetupDate");
        System.out.println(weekday);
        System.out.println(month);
        System.out.println(c.get(c.JANUARY));
        System.out.println("newSetupDate: end");
//
//        int day = Integer.parseInt(new SimpleDateFormat("dd").format(c.getTime()));
//        int month = Integer.parseInt(new SimpleDateFormat("MM").format(c.getTime()));
//        int year = Integer.parseInt(new SimpleDateFormat("yyyy").format(c.getTime()));
//
//        String monthName = new SimpleDateFormat("MMM-MM").format(c.getTime());
//        String weekday = new SimpleDateFormat("EEEEEE").format(c.getTime());


    }

    private void setupDate() {
        LocalDate date = LocalDate.now();
        int day = date.getDayOfMonth();
        String month = String.valueOf(date.getMonth());
        int year = date.getYear();
        String weekday = String.valueOf(date.getDayOfWeek());

        // Formatting
        weekday = weekday.substring(0, 1).toUpperCase() + weekday.substring(1).toLowerCase();
        month = month.substring(0, 1).toUpperCase() + month.substring(1).toLowerCase();

        ObservableList<String> monthName = FXCollections.observableList(new ArrayList<String>() {{
            months.forEach(m -> {
                System.out.println(m.getName());
                this.add(m.getName());
            });
        }});

        // The following code block is attributed to an unnamed contributor from "o7planning".
        // Site link: https://o7planning.org/11185/javafx-spinner
        SpinnerValueFactory<String> valueFactoryMonths = new SpinnerValueFactory.ListSpinnerValueFactory<String>(monthName);
        SpinnerValueFactory<Integer> valueFactoryDay = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 30, day);
        SpinnerValueFactory<Integer> valueFactoryYear = new SpinnerValueFactory.IntegerSpinnerValueFactory(year, year + 10, year);
        valueFactoryMonths.setValue(month);

        dPaneNumday.setText(String.valueOf(day));
        dPaneWeekday.setText(weekday);
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
            newSetupDate();
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
