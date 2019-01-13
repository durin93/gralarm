package com.gram.alarm.domain;

import com.fasterxml.jackson.databind.JsonNode;

public class PullData {

    private JsonNode pullRequests;

    private PullData(JsonNode pullData) {
        this.pullRequests = pullData;
    }

    public static PullData of(JsonNode pullData) {
        return new PullData(pullData);
    }


    public JsonNode getPullRequestByIndex(int i) {
        return pullRequests.get(i);
    }
}
