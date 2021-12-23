package com.gsheng.homeapi.components;

import com.gsheng.homeapi.components.obj.Timeslot;
import com.gsheng.homeapi.components.rowmapper.TimeslotRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

/*
TABLE timeslots:
    int id;
    String title;
    int repeated;
        0 = no
        1 = yes -> weekly
    String start;
    String end;

TABLE tasks:
    int id;
    String title
    int repeated;
        0 = no
        1 = yes -> weekly
    String date


*/
public class DBHandler {
    public static JdbcTemplate template;
    public static boolean ready = false;

    public static void setTemplate(JdbcTemplate template) {
        DBHandler.template = template;
        DBHandler.ready = template == null;
    }

    public static Timeslot getFirstTimeslot(){
        List<Timeslot> list = getAllTimeslots();

        return list.get(0);
    }

    public static List<Timeslot> getAllTimeslots(){
        String command = "SELECT * FROM timeslots;";
        return template.query(command, new TimeslotRowMapper());
    }

    public static int insertTimeslot(Timeslot slot){
        String command = "INSERT INTO timeslots (id, title, repeated, start, end) VALUES (?, ?, ?, ?, ?)";
        return template.update(command, slot.getId(), slot.getTitle(), slot.getRepeated(), slot.getStart().toString(), slot.getEnd().toString());
    }
}
