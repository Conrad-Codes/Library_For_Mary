package com.techelevator.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class TopicPost {
    @JsonProperty( "post_id" )
    int postId;
    @JsonProperty( "topic_id" )
    int topicId;
    String post;
    @JsonProperty( "username" )
    String postCreatedByUsername;
    @JsonProperty( "topic_date" )
    LocalDate PostCreatedDate;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPostCreatedByUsername() {
        return postCreatedByUsername;
    }

    public void setPostCreatedByUsername(String postCreatedByUsername) {
        this.postCreatedByUsername = postCreatedByUsername;
    }

    public LocalDate getPostCreatedDate() {
        return PostCreatedDate;
    }

    public void setPostCreatedDate(LocalDate postCreatedDate) {
        PostCreatedDate = postCreatedDate;
    }
}
