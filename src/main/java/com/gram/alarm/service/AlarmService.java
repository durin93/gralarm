package com.gram.alarm.service;

import com.gram.alarm.domain.Crawler;
import com.gram.alarm.domain.PullRequest;
import com.gram.alarm.domain.Reviewers;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlarmService {

    private Crawler crawler;

    @Autowired
    public AlarmService(Crawler crawler) {
        this.crawler = crawler;
    }

    public void claimToReviewer() throws IOException {
        //pr이하나라고치자.
        PullRequest pullRequest = crawler.getPullRequest(0);
        Reviewers reviewers = pullRequest.getReviewers();
        String name = reviewers.getUserName(0);
        System.out.println(name+"앗 앗앗앗");
    }
}
