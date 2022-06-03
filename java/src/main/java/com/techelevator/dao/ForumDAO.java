package com.techelevator.dao;

import com.techelevator.model.ForumTopic;
import com.techelevator.model.TopicPost;

import java.util.List;

public interface ForumDAO {

    ForumTopic getTopicByTopicId(int id);
    List<ForumTopic> getAllTopicNames();
    List<TopicPost> getAllPostsByForumTopic(int topicId);

}
