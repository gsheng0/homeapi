package com.gsheng.homeapi.components.obj;

public class Time implements Comparable<Time>{
    private int hour, minute;
    private String period = "AM";
    public Time(){

    }
    public Time(int hour, int minute, String period){
        this.hour = hour;
        this.minute = minute;
        this.period = period.toUpperCase();

    }
    public int getHour() { return hour; }
    public int getMinute() { return minute; }
    public String getPeriod() { return period; }
    public String toString() {
        return (hour < 10 ? "0" + hour : hour) + ":" + (minute < 10 ? "0" + minute : minute) + " " + period;
    }
    public static Time parseTime(String input){
        String[] split = input.split(" ");
        String[] time = split[0].split(":");
        return new Time(Integer.parseInt(time[0]), Integer.parseInt(time[1]), split[1]);
    }
    public int compareTo(Time other){
        if(other.getPeriod().equals(period)){
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
