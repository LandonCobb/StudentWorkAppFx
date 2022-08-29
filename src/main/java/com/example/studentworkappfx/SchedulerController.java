package com.example.studentworkappfx;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
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

    final ObservableList<String> monthList = FXCollections.observableArrayList(
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    );

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
        Calendar c = Calendar.getInstance();
        syncDate(c);
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

    private void syncDate(Calendar c) {
        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);

        String dayFormatted = ( (day < 10) ? "0" + Integer.toString(day) : Integer.toString(day) );
        String weekday = new SimpleDateFormat("EEEE").format(c.getTime());
        String dateString = new SimpleDateFormat("MMMM dd, yyyy").format(c.getTime());

        //mycal.getActualMaximum(Calendar.DAY_OF_MONTH)

        SpinnerValueFactory<Integer> valueFactoryYear = new SpinnerValueFactory.IntegerSpinnerValueFactory(year, year + 10, year);
        SpinnerValueFactory<String> valueFactoryMonths = new SpinnerValueFactory.ListSpinnerValueFactory<String>(monthList);
        SpinnerValueFactory<Integer> valueFactoryDay = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 30, day);
        valueFactoryMonths.setValue(monthList.get(month));

        dPaneNumday.setText(dayFormatted);
        dPaneWeekday.setText(weekday);
        txtChangeDate.setText(dateString);
        spnScheduleYEAR.setValueFactory(valueFactoryYear);
        spnScheduleMONTH.setValueFactory(valueFactoryMonths);
        spnScheduleDAY.setValueFactory(valueFactoryDay);

    }

    @FXML private void onSelectDate() throws ParseException {
        String day = spnScheduleDAY.getValue().toString();
        String month = spnScheduleMONTH.getValue().toString();
        String year = spnScheduleYEAR.getValue().toString();
        String dateString = day + "/" + month + "/" + year;

        Date date = new SimpleDateFormat("dd/MMMM/yyyy", Locale.ENGLISH).parse(dateString);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        syncDate(c);

//        System.out.println(date);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
//        LocalDate localDate = LocalDate.parse(date, formatter);
//        System.out.println("!" + localDate.toString());
    }

    @FXML private void onEditEvent(ActionEvent event) {
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(primaryStage);
        VBox dialogVbox = new VBox(20);
        dialogVbox.getChildren().add(new Text("This is a Dialog"));
        Scene dialogScene = new Scene(dialogVbox, 300, 200);
        dialog.setScene(dialogScene);
        dialog.show();

        System.out.println("onEditEvent: OK");

    }

    @FXML private void onAddEvent() {

    }

    @FXML private void onClearSchedule() {

    }

    @FXML
    protected void onGradeClick() {
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

        try {
            String url = "https://my.neumont.edu";
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        } catch (java.io.IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    protected void onDegreeClick() {

        try {
            String url = "https://degree.neumont.edu";
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        } catch (java.io.IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    protected void onTuitionClick() {

        try {
            String url = "https://tuitionoptions.accountvue.com";
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        } catch (java.io.IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    protected void onStudentClick() {

        try {
            String url = "https://portal.neumont.edu/secure/student/StuPortal.aspx";
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        } catch (java.io.IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    protected void onNotesClick(ActionEvent event)throws IOException {
        ChangeScene.changeScene(event,  "Notes.fxml");
    }



}
