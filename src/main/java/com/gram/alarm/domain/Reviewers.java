package com.gram.alarm.domain;

import com.fasterxml.jackson.databind.JsonNode;

public class Reviewers {

    private JsonNode reviewers;

    public Reviewers(JsonNode requested_reviewers) {
        this.reviewers = requested_reviewers;
    }

    public JsonNode getReviewers(){
        return reviewers;
    }

    public String getUserName(int number){
        return reviewers.get(number).path("login").asText();
    }

    public Reviewer getReviewer(int number){
        return Reviewer.of(reviewers.get(number));
    }


    public int size() {
    return reviewers.size();
    }
}
