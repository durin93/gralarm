package com.gram.alarm.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


public class PullRequestTest extends CommonTestModule{

    @Autowired
    private Crawler crawler;

    public PullData pullData;

    public PullData getPullData{
        return crawler.getPrInfo();
    }

}
