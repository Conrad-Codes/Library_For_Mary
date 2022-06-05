package com.techelevator.dao;

import com.techelevator.model.ForumTopic;
import com.techelevator.model.TopicPost;

import java.util.List;

public interface ForumDAO {

    ForumTopic getTopicByTopicId(int topicId);
    List<ForumTopic> getAllTopicNames();
    List<TopicPost> getAllPostsByForumTopicId(int topicId);

    boolean addTopicToForum( int userID, ForumTopic topic );

}
