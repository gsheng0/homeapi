package com.gsheng.homeapi.components.obj;


import com.gsheng.homeapi.components.obj.DateTime;

public class Timeslot {
    private int id;
    private String title;
    private int repeated = 0;
    private DateTime start, end;
    public Timeslot(int id, String title, int repeated, DateTime start, DateTime end){
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Repeated: " + repeated);
        System.out.println("Start: " + start);
        System.out.println("End: " + end);


        this.id = id;
        this.title = title;
        this.repeated = repeated;
        this.start = start;
        this.end = end;
    }
    public int getId() { return id;}
    public String getTitle() { return title; }
    public int getRepeated() { return repeated; }
    public DateTime getStart() { return start; }
    public DateTime getEnd() { return end; }
    public String toString() {
        return "Timeslot: " + title + "\n\tId: " + id + "\n\tRepeated: " + repeated + "\n\tStart: " + start + "\n\tEnd: " + end;
    }
}