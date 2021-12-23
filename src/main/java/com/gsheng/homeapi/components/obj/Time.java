package com.gsheng.homeapi.components.obj;

public class Time implements Comparable<Time>{
    private int hour, minute;
    private String m = "AM";
    public Time(int hour, int minute, String m){
        this.hour = hour;
        this.minute = minute;
        this.m = m.toUpperCase();
    }
    public int getHour() { return hour; }
    public int getMinute() { return minute; }
    public String getPeriod() { return m; }
    public String toString() {
        return (hour < 10 ? "0" + hour : hour) + ":" + (minute < 10 ? "0" + minute : minute) + " " + m;
    }
    public int compareTo(Time other){
        if(other.getPeriod().equals(m)){
            if(other.getHour() == hour){
                if(other.getMinute() == minute){
                    return 0;
                }
                else if(other.getMinute() < minute){
                    return 1;
                }
                else{
                    return -1;
                }
            }
            else if(other.getHour() == 12){
                return 1;
            }
            else if(hour == 12){
                return -1;
            }
            else if(other.getHour() < hour){
                return 1;
            }
            else{
                return -1;
            }
        }
        if(other.getPeriod().equals("AM")){
            return 1;
        }
        return -1;
    }
}
