package com.gram.alarm.domain;

import com.google.common.collect.Lists;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class SlackNotifier {

    @Autowired
    private RestTemplate restTemplate;

    public enum SlackTarget {

        CH_INCOMING("https://hooks.slack.com/services/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", "test-slack");
        String webHookUrl;
        String channel;

        SlackTarget(String webHookUrl, String channel) {
            this.webHookUrl = webHookUrl;
            this.channel = channel;
        }
    }

    public static class SlackMessageAttachement {

        private String color;
        private String pretext;
        private String title;
        private String title_link;
        private String text;

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getPretext() {
            return pretext;
        }

        public void setPretext(String pretext) {
            this.pretext = pretext;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle_link() {
            return title_link;
        }

        public void setTitle_link(String title_link) {
            this.title_link = title_link;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    public static class SlackMessage {

        private String text;
        private String channel;
        private List<SlackMessageAttachement> attachments;

        void addAttachment(SlackMessageAttachement attachement) {
            if (this.attachments == null) {
                this.attachments = Lists.newArrayList();
            }
            this.attachments.add(attachement);
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public List<SlackMessageAttachement> getAttachments() {
            return attachments;
        }

        public void setAttachments(List<SlackMessageAttachement> attachments) {
            this.attachments = attachments;
        }
    }

    public boolean notify(SlackTarget target, SlackMessageAttachement message) {
        SlackMessage slackMessage = new SlackMessage();
        slackMessage.setChannel(target.channel);
        slackMessage.setText("1234");
        slackMessage.setAttachments(Lists.newArrayList(message));
        try {
            restTemplate.postForEntity(target.webHookUrl, slackMessage, String.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
