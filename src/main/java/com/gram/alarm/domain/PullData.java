package com.gram.alarm.domain;

import com.fasterxml.jackson.databind.JsonNode;
import com.gram.alarm.domain.slack.SlackNotifier;

public class PullData {

    private JsonNode pullRequests;

    private PullData(JsonNode pullData) {
        this.pullRequests = pullData;
    }

    public static PullData of(JsonNode pullData) {
        return new PullData(pullData);
    }

    public void makeMessage(SlackNotifier slackNotifier) {
        for (int i = 0; i < pullRequests.size(); i++) {
            PullRequest pullRequest = PullRequest.of(pullRequests.get(i));
            pullRequest.makeMessage(slackNotifier);
        }
    }

}
