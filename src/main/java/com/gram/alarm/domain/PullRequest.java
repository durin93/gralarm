package com.gram.alarm.domain;

import com.fasterxml.jackson.databind.JsonNode;



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


    public Reviewers getReviewers() {
        return reviewers;
    }

    public JsonNode getPullRequest() {
        return pullRequest;
    }
}
