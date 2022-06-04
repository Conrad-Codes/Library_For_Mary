package com.techelevator.model;

import java.time.LocalDate;

public class ForumTopic {
    int topicId;
    String topicName;
    String CreatedByUsername;
    LocalDate topicCreatedDate;

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getCreatedByUsername() {
        return CreatedByUsername;
    }

    public void setCreatedByUsername(String createdByUsername) {
        CreatedByUsername = createdByUsername;
    }

    public LocalDate getTopicCreatedDate() {
        return topicCreatedDate;
    }

    public void setTopicCreatedDate(LocalDate topicCreatedDate) {
        this.topicCreatedDate = topicCreatedDate;
    }
}