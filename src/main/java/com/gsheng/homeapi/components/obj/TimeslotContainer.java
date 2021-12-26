package com.gsheng.homeapi.components.obj;

public class TimeslotContainer {
    private int id, repeated;
    private String title;
    private DateTimeContainer start, end;
    public TimeslotContainer(int id, String title, int repeated, DateTimeContainer start, DateTimeContainer end){
        this.id = id;
        this.repeated = repeated;
        this.title = title;
        this.start = start;
        this.end = end;
    }
    public Timeslot toTimeslot(){
        return new Timeslot(id, title, repeated, start.toDateTime(), end.toDateTime());
    }
}
