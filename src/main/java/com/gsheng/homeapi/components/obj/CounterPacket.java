package com.gsheng.homeapi.components.obj;

public class CounterPacket {
    private int taskCounter, timeslotCounter;
    public CounterPacket(int task, int timeslot){
        taskCounter = task;
        timeslotCounter = timeslot;
    }
    public CounterPacket(){}
    public void setTaskCounter(int task){ taskCounter = task; }
    public void setTimeslotCounter(int timeslot) { timeslotCounter = timeslot; }
    public int getTaskCounter() { return taskCounter; }
    public int getTimeslotCounter() { return timeslotCounter; }
    public String toString() {
        return "Task Counter: " + taskCounter + "\nTimeslot Counter: " + timeslotCounter;
    }
}
