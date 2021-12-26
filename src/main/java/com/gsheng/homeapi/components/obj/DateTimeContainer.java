package com.gsheng.homeapi.components.obj;

public class DateTimeContainer {
    private int month, day, year, hour, minute;
    private String period = "AM";
    public DateTimeContainer(int month, int day, int year, int hour, int minute, String period){
        this.month = month;
        this.day = day;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
        this.period = period;
    }
    public DateTime toDateTime() {
        return new DateTime(month, day, year, hour, minute, period);
    }
}
