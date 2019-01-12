package com.gram.alarm.domain;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonTestModule {

    @Autowired
    public Crawler crawler;

//    public PullData getPullData(){
//      return crawler.getPrInfo(;
//    }

}
