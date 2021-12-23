package com.gsheng.homeapi.components.obj;

public class Task {
    private int id;
    private String title;
    private int repeated;
    private DateTime date;
    public Task(int id, String title, int repeated, DateTime date){
        this.id = id;
        this.title = title;
        this.repeated = repeated;
        this.date = date;
    }
    public int getId() { return id;}
    public String getTitle() { return title; }
    public int getRepeated() { return repeated; }
    public DateTime getDate() { return date; }
    public String toString(){
        return "Task " + title + "\n\tId: " + id + "\n\tRepeated: " + repeated + "\n\tDate: " + date;

    }
}
