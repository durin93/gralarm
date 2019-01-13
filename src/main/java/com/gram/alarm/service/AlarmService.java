package com.gram.alarm.service;

import com.gram.alarm.domain.Crawler;
import com.gram.alarm.domain.PullRequest;
import com.gram.alarm.domain.Reviewer;
import com.gram.alarm.domain.Reviewers;
import com.gram.alarm.domain.SlackNotifier;
import com.gram.alarm.domain.SlackNotifier.SlackMessageAttachement;
import com.gram.alarm.domain.SlackNotifier.SlackTarget;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlarmService {

    private Crawler crawler;

    private SlackNotifier slackNotifier;


    @Autowired
    public AlarmService(Crawler crawler, SlackNotifier slackNotifier) {
        this.crawler = crawler;
        this.slackNotifier = slackNotifier;
    }

    public Reviewer claimToReviewer() throws IOException {
        //pr이하나라고치자.
        PullRequest pullRequest = crawler.getPullRequest(0);
        Reviewers reviewers = pullRequest.getReviewers();

        Reviewer reviewer = reviewers.getReviewer(0);
        String message = "requester "+pullRequest.getPullRequest().path("user").path("login").asText()+" reviewer"+reviewer +reviewer.getName();

        SlackMessageAttachement slackMessageAttachement = new SlackMessageAttachement();
        slackMessageAttachement.setTitle("pullRequest 발생");
        slackMessageAttachement.setText(message);
        slackMessageAttachement.setTitle_link(pullRequest.getPullRequest().get("html_url").asText());
        slackNotifier.notify(SlackTarget.CH_INCOMING, slackMessageAttachement);
        return reviewer;
    }
}
