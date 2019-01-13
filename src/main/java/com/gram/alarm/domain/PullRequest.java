package com.gram.alarm.domain;

import com.fasterxml.jackson.databind.JsonNode;



public class PullRequest {

    private Reviewers reviewers;

    public PullRequest(JsonNode reviewers) {
        this.reviewers = new Reviewers(reviewers.path("requested_reviewers"));
    }

    public static PullRequest of(JsonNode reviewers) {
        return new PullRequest(reviewers);
    }


    public Reviewers getReviewers() {
        return reviewers;
    }

}
