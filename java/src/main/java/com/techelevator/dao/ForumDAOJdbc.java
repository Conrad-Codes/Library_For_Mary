package com.techelevator.dao;

import com.techelevator.model.ForumTopic;
import com.techelevator.model.TopicPost;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ForumDAOJdbc implements ForumDAO{
    private JdbcTemplate jdbcTemplate;

    public ForumDAOJdbc( JdbcTemplate jdbcTemplate ) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ForumTopic getTopicByTopicId(int topicId) {
        ForumTopic forumTopic = null;
        String sql = "SELECT forum_topic.topic_id, forum_topic.topic_name" +
                ", users.username, forum_topic.topic_date\n" +
                "FROM forum_topic\n" +
                "JOIN users\n" +
                "ON forum_topic.user_id = users.user_id\n" +
                "WHERE forum_topic.topic_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet( sql, topicId );
        if( results.next() ) {
            forumTopic = mapRowToForumTopic( results );
        }
        return forumTopic;
    }

    @Override
    public List<ForumTopic> getAllTopicNames() {
        List<ForumTopic> forumTopics = new ArrayList<>();
        String sql = "SELECT forum_topic.topic_id, forum_topic.topic_name" +
                ", users.username, forum_topic.topic_date\n" +
                "FROM forum_topic\n" +
                "JOIN users\n" +
                "ON forum_topic.user_id = users.user_id";
        SqlRowSet results = jdbcTemplate.queryForRowSet( sql );
        while( results.next() ) {
            ForumTopic forumTopic = mapRowToForumTopic( results );
            forumTopics.add( forumTopic );
        }
        return forumTopics;
    }

    @Override
    public List<TopicPost> getAllPostsByForumTopicId(int topicId) {
        List<TopicPost> topicPosts = new ArrayList<>();
        String sql = "SELECT forum_post.post_id, forum_post.topic_id " +
                ", forum_post.post, users.username, forum_post.post_date\n" +
                "FROM forum_post\n" +
                "JOIN forum_topic\n" +
                "ON forum_post.topic_id = forum_topic.topic_id\n" +
                "JOIN users\n" +
                "ON forum_post.user_id = users.user_id\n" +
                "WHERE forum_post.topic_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet( sql, topicId );
        while( results.next() ) {
            TopicPost topicPost = mapRowToTopicPost( results );
            topicPosts.add( topicPost );
        }
        return topicPosts;
    }

    private ForumTopic mapRowToForumTopic(SqlRowSet rowSet ) {
        ForumTopic forumTopic = new ForumTopic();

        forumTopic.setTopicId( rowSet.getInt( "topic_id" ) );
        forumTopic.setTopicName( rowSet.getString( "topic_name" ) );
        forumTopic.setCreatedByUsername( rowSet.getString( "username" ) );
        forumTopic.setTopicCreatedDate( rowSet.getDate( "topic_date" ).toLocalDate() );

        return forumTopic;
    }

    private TopicPost mapRowToTopicPost( SqlRowSet rowSet ) {
        TopicPost topicPost = new TopicPost();

        topicPost.setPostId( rowSet.getInt( "post_id" ) );
        topicPost.setTopicId( rowSet.getInt( "topic_id" ) );
        topicPost.setPost( rowSet.getString( "post" ) );
        topicPost.setPostCreatedByUsername( rowSet.getString( "username" ) );
        topicPost.setPostCreatedDate( rowSet.getDate( "post_date" ).toLocalDate() );

        return topicPost;
    }
}
