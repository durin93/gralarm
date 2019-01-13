package com.gram.alarm.web;

import com.gram.alarm.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GralarmController {


    private AlarmService alarmService;


    @Autowired
    public GralarmController(AlarmService alarmService) {
        this.alarmService = alarmService;
    }


    @GetMapping("/")
    public String main() {
        alarmService.claimToReviewer();
        return "index";
    }


}
