package com.gsheng.homeapi.components.obj;

public class DateTime implements Comparable<DateTime>{
    private Date date;
    private Time time;
    public DateTime(){}
    public DateTime(int month, int day, int year, int hour, int minute, String period){
        date = new Date(month, day, year);
        time = new Time(hour, minute, period);
    }
    public Date getDate() { return date; }
    public Time getTime() { return time; }
    public static DateTime parseDate(String input){
        /*
        Format for string parsing should be:
        MM/DD/YYYY HH:MM AM
         */
        String[] split = input.split(" ");
        String m = split[2].toUpperCase();

        String[] date = split[0].split("/");
        if(date.length < 3){
            date = split[0].split("-");
        }
        int month = Integer.parseInt(date[0]);
        int day = Integer.parseInt(date[1]);
        int year = Integer.parseInt(date[2]);

        String[] time = split[1].split(":");
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);
        return new DateTime(month, day, year, hour, minute, m);
    }
    public String toString(){
        return getDate() + " " + getTime();
    }
    public String toString(boolean notAmerican){
        return date.toString(notAmerican) + " " + getTime();
    }
    public int compareTo(DateTime other){
        if(date.compareTo(other.date) != 0){
            return date.compareTo(other.date);
        }
        else return time.compareTo(other.time);
    }
}
