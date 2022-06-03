package com.techelevator.model;

import java.time.LocalDateTime;

public class TopicPost {
    int postId;
    int topicId;
    String post;
    String postCreatedByUsername;
    LocalDateTime PostCreatedDate;

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

    public LocalDateTime getPostCreatedDate() {
        return PostCreatedDate;
    }

    public void setPostCreatedDate(LocalDateTime postCreatedDate) {
        PostCreatedDate = postCreatedDate;
    }
}
