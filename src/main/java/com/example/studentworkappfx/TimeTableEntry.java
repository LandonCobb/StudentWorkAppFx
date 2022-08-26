package com.example.studentworkappfx;

public class TimeTableEntry {
    private String time;
    private String event;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public TimeTableEntry(String time, String event) {
        this.time = time;
        this.event = event;
    }



}
