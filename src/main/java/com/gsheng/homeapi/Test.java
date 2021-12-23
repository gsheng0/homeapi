package com.gsheng.homeapi;

import com.gsheng.homeapi.components.obj.DateTime;

public class Test {
    public static void main(String[] args){
        DateTime time = DateTime.parseDate("1/12/2021 14:00 PM");
        System.out.println(time);
        System.out.println(time.toString(true));
    }
}
