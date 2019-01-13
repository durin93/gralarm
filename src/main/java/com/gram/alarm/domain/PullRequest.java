package com.gram.alarm.domain;

import com.fasterxml.jackson.databind.JsonNode;
import com.gram.alarm.domain.SlackNotifier.SlackTarget;


public class PullRequest {

    private JsonNode pullRequest;
    private Reviewers reviewers;


    public PullRequest(JsonNode pullRequest) {
        this.pullRequest = pullRequest;
        this.reviewers = new Reviewers(pullRequest.path("requested_reviewers"));
    }

    public static PullRequest of(JsonNode reviewers) {
        return new PullRequest(reviewers);
    }


    public void makeMessage(SlackNotifier slackNotifier) {
        for (int k = 0; k < reviewers.size(); k++) {
            slackNotifier.attachMessage(makeMessage(reviewers.getReviewer(k)), pullRequest);
            slackNotifier.notify(SlackTarget.CH_INCOMING);
        }
    }

    private String makeMessage(Reviewer reviewer){
        return
        "requester : " + pullRequest.path("user").path("login").asText() + "\n reviewer "
            + reviewer
            .getName()+"\n title : "+pullRequest.path("title")+"\n body : "+pullRequest.path("body");
    }

}
