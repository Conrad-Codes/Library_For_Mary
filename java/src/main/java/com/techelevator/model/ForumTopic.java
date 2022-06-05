package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class ForumTopic {

    @JsonProperty("topic_id")
    int topicId;
    @JsonProperty("topic_name")
    String topicName;
    @JsonProperty("username")
    String CreatedByUsername;
    @JsonProperty("topic_date")
    LocalDate topicCreatedDate;

    public ForumTopic() {}

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