package com.gram.alarm.web;

import com.gram.alarm.domain.Crawler;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GralarmController {

    private Crawler crawler;

    public GralarmController(Crawler crawler) {
        this.crawler = crawler;
    }

    @GetMapping("/")
    public String main() throws IOException {
        crawler.getPrInfo();
        return "index";
    }

}
