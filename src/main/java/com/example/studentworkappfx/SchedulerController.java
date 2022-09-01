package com.example.studentworkappfx;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SchedulerController implements Initializable {
    @FXML private Label timeLabel;
    @FXML private Text dPaneNumday;
    @FXML private Text dPaneWeekday;
    @FXML private Text txtChangeDate;
    @FXML private TextField tfEvent;
    @FXML private Spinner<Integer> spnScheduleDAY;
    @FXML private Spinner<String> spnScheduleMONTH;
    @FXML private Spinner<Integer> spnScheduleYEAR;
    @FXML private Spinner<String> spnTimeSel1;
    @FXML private Spinner<String> spnTimeSel2;
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

    //TODO: Refactor or remove this variable entirely!
    final ObservableList<String> timeList = FXCollections.observableArrayList(
            "6:00", "6:30", "7:00", "7:30", "8:00", "8:30", "9:00", "9:30",
            "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "1:00", "1:30",
            "2:00", "2:30", "3:00", "3:30", "4:00", "4:30", "5:00", "5:30",
            "6:00", "6:30", "7:00", "7:30", "8:00", "8:30", "9:00", "9:30", "10:00"
    );

    @FXML
    public void timeClicked(MouseEvent mouseEvent) throws IOException {
        ChangeScene.getModal(mouseEvent, "Clock.fxml", "NSC Stopwatch");
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
        public void setEvent(String event) { this.event = event;}

        @Override
        public String toString() {
            return "{" + time + "," + event + "}";
        }
    }

    private ObservableList<TimeTableEntry> timeTableData = FXCollections.observableArrayList(
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

    private void updateTimeTable() {
        timeTableTimes.setCellValueFactory(new PropertyValueFactory<>("time"));
        timeTableEvents.setCellValueFactory(new PropertyValueFactory<>("event"));
        timeTable.setItems(timeTableData);
    }

    private void miscSetup() {
        SpinnerValueFactory<String> valueFactoryTime1 = new SpinnerValueFactory.ListSpinnerValueFactory<String>(timeList);
        SpinnerValueFactory<String> valueFactoryTime2 = new SpinnerValueFactory.ListSpinnerValueFactory<String>(timeList);
        spnTimeSel1.setValueFactory(valueFactoryTime1);
        spnTimeSel2.setValueFactory(valueFactoryTime2);
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
        onClearSchedule();
    }

    @FXML private void onAddEvent() {
        String t1 = spnTimeSel1.getValue().toString();
        String t2 = spnTimeSel2.getValue().toString();
        String event = tfEvent.getText();

        int t1_index = timeList.indexOf(t1);
        int t2_index = timeList.indexOf(t2);

        if ( (t1_index != -1) && (t2_index != -1) && (t1_index <= t2_index)) {
            for (int i = t1_index; i <= t2_index; i++) {
                timeTableData.get(i).setEvent(event);
            }
        }

        timeTable.refresh();
    }

    @FXML private void onClearSchedule() {
        for (int i = 0; i < timeTableData.size(); i++) {
            timeTableData.get(i).setEvent("");
        }

        timeTable.refresh();
    }

    private void doWebLink(String url) {
        // code below was made possible with the help of Stack overflow https://stackoverflow.com/questions/10967451/open-a-link-in-browser-with-java-button
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
            // goes to the desktop and searches the url through the main search engine
        } catch (java.io.IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML private void onResLink1() {
        doWebLink("https://lms.neumont.edu");
    }
    @FXML private void onResLink2() {
        doWebLink("https://my.neumont.edu");
    }
    @FXML private void onResLink3() {
        doWebLink("https://degree.neumont.edu");
    }
    @FXML private void onResLink4() {
        doWebLink("https://tuitionoptions.accountvue.com");
    }
    @FXML private void onResLink5() {
        doWebLink("https://portal.neumont.edu/secure/student/StuPortal.aspx");
    }

    @FXML private void onNotesClick(ActionEvent event) throws IOException {
        ChangeScene.getModal(event, "Notes.fxml", "NSC Notes");
    }

    @FXML private void onCalcClick(ActionEvent event) throws IOException {
        ChangeScene.getModal(event,  "Calc.fxml", "NSC Calculator");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> {
            miscSetup();
            setupDate();
            updateTimeTable();
        });
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
            timeLabel.setText(Clock.getCurrentTime());
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }





//    @FXML
//    protected void onCalcClick(ActionEvent event)throws IOException {
//        ChangeScene.changeScene(event,  "Notes.fxml");
//    }




}
