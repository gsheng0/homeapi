package com.gsheng.homeapi.components.obj;

public class DateTime {
    private int day, month, year, hour, minute;
    private String m;
    private DateTime(){}
    public DateTime(int month, int day, int year, int hour, int minute, String m){
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
        this.m = m.toUpperCase();
    }
    public int getDay() { return day;}
    public int getMonth() { return month;}
    public int getYear() { return year; }
    public int getHour() { return hour;}
    public int getMinute() { return minute; }
    public String getDate(){
        return month + "/" + day + "/" + year;
    }
    public String getDate(boolean notAmerican){
        return (notAmerican ? day + "/" + month : month + "/" + day) + "/" + year;
    }
    public String getTime() {
        return (hour < 10 ? "0" + hour : hour) + ":" + (minute < 10 ? "0" + minute : minute) + " " + m;
    }
    public static DateTime parseDate(String input){
        /*
        Format for string parsing should be:
        MM/DD/YYYY HH:MM AM
         */
        String[] split = input.split(" ");
        DateTime out = new DateTime();
        out.m = split[2].toUpperCase();

        String[] date = split[0].split("/");
        if(date.length < 3){
            date = split[0].split("-");
        }
        out.month = Integer.parseInt(date[0]);
        out.day = Integer.parseInt(date[1]);
        out.year = Integer.parseInt(date[2]);

        String[] time = split[1].split(":");
        out.hour = Integer.parseInt(time[0]);
        out.minute = Integer.parseInt(time[1]);
        return out;
    }
    public String toString(){
        return getDate() + " " + getTime();
    }
    public String toString(boolean notAmerican){
        return getDate(notAmerican) + " " + getTime();
    }
}
