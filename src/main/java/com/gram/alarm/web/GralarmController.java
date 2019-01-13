package com.gram.alarm.web;

import com.gram.alarm.domain.Alarm;
import com.gram.alarm.domain.Crawler;
import com.gram.alarm.service.CrawlerService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GralarmController {

    private Crawler crawler;

    private CrawlerService crawlerService;

    @Autowired
    public GralarmController(Crawler crawler, CrawlerService crawlerService) {
        this.crawler = crawler;
        this.crawlerService = crawlerService;
    }


    @GetMapping("/")
    public String main() throws IOException {
        crawler.getReviewer(crawler.getPrInfo());
        return "index";
    }

}
