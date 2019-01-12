package com.gram.alarm.web;

import com.gram.alarm.domain.Crawler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GralarmController {

    private Crawler crawler;

    @GetMapping("/")
    public String main(){
        return "index";
    }

}
