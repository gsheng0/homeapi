package com.gsheng.homeapi;

import com.gsheng.homeapi.components.DBHandler;
import com.gsheng.homeapi.components.obj.CounterPacket;
import com.gsheng.homeapi.components.obj.DateTime;
import com.gsheng.homeapi.components.obj.Task;
import com.gsheng.homeapi.components.obj.Timeslot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.css.Counter;

import javax.annotation.PostConstruct;
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
    @GetMapping("/")
    public String home(){
        return "This is the home page";
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
        slot.setId(timeslotCounter);
        timeslotCounter++;
        DBHandler.updateTimeslotCounter(timeslotCounter);
        DBHandler.insertTimeslot(slot);
    }



}
