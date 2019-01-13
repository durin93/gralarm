package com.gram.alarm.domain.slack;

import com.google.common.collect.Lists;
import java.util.List;

public class SlackMessage {

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
