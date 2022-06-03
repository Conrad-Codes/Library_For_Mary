package com.techelevator.dao;

import com.techelevator.model.ForumTopic;
import com.techelevator.model.TopicPost;

import java.util.List;

public class ForumDAOJdbc implements ForumDAO{

    @Override
    public ForumTopic getTopicByTopicId(int id) {
        return null;
    }

    @Override
    public List<ForumTopic> getAllTopicNames() {
        return null;
    }

    @Override
    public List<TopicPost> getAllPostsByForumTopic(int topicId) {
        return null;
    }
}
