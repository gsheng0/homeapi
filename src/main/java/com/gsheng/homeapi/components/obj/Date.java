package com.gsheng.homeapi.components.obj;

public class Date implements Comparable<Date>{
    private int day, month, year;
    public Date(){}
    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }
    public int getDay() { return day; }
    public int getMonth() { return month; }
    public int getYear() { return year; }
    public String toString() {
        return month + "/" + day + "/" + year;
    }
    public String toString(boolean notAmerican){
        return (notAmerican ? day + "/" + month : month + "/" + day) + "/" + year;
    }
    public DateTime toDate(){
        return new DateTime(month, day, year, 12, 0, "AM");
    }
    public static Date parseDate(String str){
        String[] strs = str.split("/");
        if(strs.length < 3){
            strs = str.split("-");
        }
        return new Date(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]), Integer.parseInt(strs[2]));
    }
    public int compareTo(Date other){
        if(other.year < year){
            return 1;
        }
        else if(other.year > year){
            return -1;
        }
        else{
            if(other.month == month){
                if(other.day == day){
                    return 0;
                }
                else if(other.day < day){
                    return 1;
                }
                return -1;
            }
            else if(other.month > month){
                return -1;
            }
            else{
                return 1;
            }
        }
    }
}
