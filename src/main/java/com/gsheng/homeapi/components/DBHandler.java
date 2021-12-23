package com.gsheng.homeapi.components;

import com.gsheng.homeapi.components.obj.Task;
import com.gsheng.homeapi.components.obj.Timeslot;
import com.gsheng.homeapi.components.rowmapper.CounterMapper;
import com.gsheng.homeapi.components.rowmapper.TaskRowMapper;
import com.gsheng.homeapi.components.rowmapper.TimeslotRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PreDestroy;
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

    public static int getTimeslotCounter(){
        String command = "SELECT counter FROM counters WHERE tablename = ?";
        return template.query(command, new CounterMapper(), "timeslots").get(0);
    }
    public static int getTaskCounter(){
        String command = "SELECT counter FROM counters WHERE tablename = ?";
        return template.query(command, new CounterMapper(), "tasks").get(0);
    }

    public static List<Timeslot> getAllTimeslots(){
        String command = "SELECT * FROM timeslots;";
        return template.query(command, new TimeslotRowMapper());
    }
    public static List<Task> getAllTasks(){
        String command = "SELECT * FROM tasks";
        return template.query(command, new TaskRowMapper());
    }

    public static int insertTimeslot(Timeslot slot){
        String command = "INSERT INTO timeslots (id, title, repeated, start, end) VALUES (?, ?, ?, ?, ?)";
        return template.update(command, slot.getId(), slot.getTitle(), slot.getRepeated(), slot.getStart().toString(), slot.getEnd().toString());
    }
    public static int updateTimeslotCounter(int counter){
        String command = "UPDATE counters SET counter = ? WHERE tablename = ?";
        return template.update(command, counter, "timeslots");
    }
    public static int updateTaskCounter(int counter){
        String command = "UPDATE counters SET counter = ? WHERE tablename = ?";
        return template.update(command, counter, "tasks");
    }

    public static void correctCounters(){
        int numTasks = getAllTasks().size();
        int numTimeslots = getAllTimeslots().size();
        updateTaskCounter(numTasks);
        updateTimeslotCounter(numTimeslots);
    }

}

/*
For command line mysql:
    1. ln -s /usr/local/mysql/bin/mysql /usr/local/bin/mysql
    2. mysql -u root -p
    3. Enter password
 */
