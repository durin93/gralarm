package com.gram.alarm.domain.slack;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class SlackNotifier {

    private RestTemplate restTemplate;

    private SlackMessageAttachement slackMessageAttachement = new SlackMessageAttachement();

    private SlackMessage slackMessage = new SlackMessage();


    @Autowired
    public SlackNotifier(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void attachMessage(String reviewer, JsonNode pullRequest) {
        slackMessageAttachement.setAuthor_name(reviewer +" 님 !!!");
        slackMessageAttachement.setText("requester : " + pullRequest.path("user").path("login").asText());
        slackMessageAttachement.setTitle_link(pullRequest.path("html_url").asText());
        slackMessageAttachement.setText("title "+pullRequest.path("title")+"\n body " +pullRequest.path("body"));
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
        slackMessage.setText("Gralarm API v1.0");
        slackMessage.setAttachments(Lists.newArrayList(slackMessageAttachement));
        try {
            restTemplate.postForEntity(target.webHookUrl, slackMessage, String.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
