package com.gram.alarm.service;

import com.gram.alarm.domain.Crawler;
import com.gram.alarm.domain.PullData;
import com.gram.alarm.domain.slack.SlackNotifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlarmService {

    private Crawler crawler;

    private SlackNotifier slackNotifier;


    @Autowired
    public AlarmService(Crawler crawler,  SlackNotifier slackNotifier) {
        this.crawler = crawler;
        this.slackNotifier = slackNotifier;
    }

    public void claimToReviewer() {
        makeAlarm(crawler.crawlRepositoryData());
    }

    public void makeAlarm(PullData pullData) {
        pullData.makeMessage(slackNotifier);
    }


}
