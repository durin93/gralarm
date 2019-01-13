package com.gram.alarm.domain;

import com.fasterxml.jackson.databind.JsonNode;
import com.gram.alarm.domain.SlackNotifier.SlackTarget;

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
//
//    public void sendToSlack(String message, PullRequest pullRequest) {
//        slackNotifier.attachMessage(message, pullRequest);
////        slackMessageAttachement.setTitle("pullRequest 보냈습니다.");
////        slackMessageAttachement.setText(message);
////        slackMessageAttachement.setTitle_link(pullRequest.getPullRequest().get("html_url").asText());
//        slackNotifier.notify(SlackTarget.CH_INCOMING);
//    }
}
