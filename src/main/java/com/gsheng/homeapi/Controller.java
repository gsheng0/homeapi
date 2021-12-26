package com.gsheng.homeapi;

import com.gsheng.homeapi.components.DBHandler;
import com.gsheng.homeapi.components.obj.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.css.Counter;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class Controller {
    @Autowired
    private JdbcTemplate template;
    @Autowired
    private ApplicationContext context;
    private int timeslotCounter, taskCounter; //hold the id values to be used for next insertion

    @PostConstruct
    public void init(){
        DBHandler.setTemplate(template);
        timeslotCounter = DBHandler.getTimeslotCounter();
        taskCounter = DBHandler.getTaskCounter();

    }

    @GetMapping("/get/timeslot/all")
    public List<Timeslot> getAllTimeslots(){
        return DBHandler.getAllTimeslots();
    }

    @GetMapping("/correct")
    public CounterPacket correctCounter(){
        DBHandler.correctCounters();
        timeslotCounter = DBHandler.getTimeslotCounter();
        taskCounter = DBHandler.getTaskCounter();
        CounterPacket packet = new CounterPacket();
        packet.setTaskCounter(taskCounter);
        packet.setTimeslotCounter(timeslotCounter);
        return packet;
    }

    @PostMapping("/add/task")
    public void addTask(@RequestBody Task task){
        task.setId(taskCounter);
        taskCounter++;
        DBHandler.updateTaskCounter(taskCounter);
        DBHandler.insertTask(task);
    }

    @PostMapping("/add/timeslot")
    public void addTimeslot(@RequestBody Timeslot slot){
        System.out.println(slot);
        slot.setId(timeslotCounter);
        timeslotCounter++;
        DBHandler.updateTimeslotCounter(timeslotCounter);
        DBHandler.insertTimeslot(slot);
    }

    @GetMapping("/")
    public Timeslot insertTimeslot(){
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        DateTime start = new DateTime(month, day, year, 12, 0, "AM");
        DateTime end = new DateTime(month, day, year, (int)(Math.random() * 12) + 1, 0,"PM");
        Timeslot temp = new Timeslot(timeslotCounter, "Timeslot " + timeslotCounter, 0, start, end);
        timeslotCounter++;
        DBHandler.updateTimeslotCounter(timeslotCounter);
        DBHandler.insertTimeslot(temp);
        return temp;
    }




}
