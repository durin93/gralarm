package com.gram.alarm;

import com.gram.alarm.domain.Crawler;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class CrawlerTest {

    private Crawler crawler;
    private RestTemplate restTemplate;

    @Before
    public void setUp(){
        restTemplate = new RestTemplate();
        crawler = new Crawler(restTemplate);
    }

//    @Test
//    public void getPrInfo() throws IOException {
//
//       crawler.getPrInfo();
//
//    }

}
