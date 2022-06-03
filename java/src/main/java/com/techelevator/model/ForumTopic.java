package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ForumTopic {
    int topicId;
    String topicName;
    String CreatedByUsername;
    LocalDateTime topicCreatedDate;

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

    public LocalDateTime getTopicCreatedDate() {
        return topicCreatedDate;
    }

    public void setTopicCreatedDate(LocalDateTime topicCreatedDate) {
        this.topicCreatedDate = topicCreatedDate;
    }
}