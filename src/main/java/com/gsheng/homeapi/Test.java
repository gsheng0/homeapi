package com.gsheng.homeapi;

import com.gsheng.homeapi.components.DBHandler;
import com.gsheng.homeapi.components.obj.DateTime;
import com.gsheng.homeapi.components.obj.Timeslot;

public class Test {
    public static void main(String[] args){
        DBHandler.insertTimeslot(new Timeslot(100, "TEST TIMESLOT", 0,
                new DateTime(12, 31, 2021, 12, 0, "AM"),
                new DateTime(12, 31, 2021, 12, 0, "PM")));
    }
}
