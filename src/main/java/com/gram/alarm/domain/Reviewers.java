package com.gram.alarm.domain;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;
import java.util.Map;

public class Reviewers {

    private JsonNode reviewers;

    public Reviewers(JsonNode requested_reviewers) {
        this.reviewers = requested_reviewers;
    }

    public String getUserName(int number){
        return reviewers.get(number).path("login").asText();
    }

}
