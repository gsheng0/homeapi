package com.gsheng.homeapi;

import com.gsheng.homeapi.components.DBHandler;
import com.gsheng.homeapi.components.obj.DateTime;
import com.gsheng.homeapi.components.obj.Timeslot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@CrossOrigin("*")
public class Controller {
    @Autowired
    private JdbcTemplate template;
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

    @GetMapping("/data")
    public List<Timeslot> getTimeSlot(){
        return DBHandler.getAllTimeslots();
    }

    @GetMapping("/insert")
    public int insert(){
        return DBHandler.insertTimeslot(new Timeslot(1, "Second timeslot", 0, DateTime.parseDate("12/12/2021 7:00 PM"), DateTime.parseDate("12/12/2021 8:00 PM")));
    }


}
