package com.gram.alarm.domain;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class SlackNotifier {

    private RestTemplate restTemplate;

    private SlackMessageAttachement slackMessageAttachement;

    private SlackMessage slackMessage;


    @Autowired
    public SlackNotifier(RestTemplate restTemplate, SlackMessageAttachement slackMessageAttachement,
        SlackMessage slackMessage) {
        this.restTemplate = restTemplate;
        this.slackMessageAttachement = slackMessageAttachement;
        this.slackMessage = slackMessage;
    }

    public void attachMessage(String message, JsonNode pullRequest) {
        slackMessageAttachement.setTitle("PR 보냈습니다~~~");
        slackMessageAttachement.setText(message);
        slackMessageAttachement.setTitle_link(pullRequest.path("html_url").asText());
    }

    public enum SlackTarget {

        CH_INCOMING("https://hooks.slack.com/services/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", "test-slack");
        String webHookUrl;
        String channel;

        SlackTarget(String webHookUrl, String channel) {
            this.webHookUrl = webHookUrl;
            this.channel = channel;
        }
    }


    public boolean notify(SlackTarget target) {
        slackMessage.setChannel(target.channel);
        slackMessage.setText("Gralarm @@@@");
        slackMessage.setAttachments(Lists.newArrayList(slackMessageAttachement));
        try {
            restTemplate.postForEntity(target.webHookUrl, slackMessage, String.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
