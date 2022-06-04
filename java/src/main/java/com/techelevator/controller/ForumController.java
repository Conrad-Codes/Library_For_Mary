package com.techelevator.controller;

import com.techelevator.dao.ForumDAO;
import com.techelevator.model.ForumTopic;
import com.techelevator.model.TopicPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
//@PreAuthorize("isAuthenticated()")
public class ForumController {
    @Autowired
    ForumDAO forumDAO;

    public ForumController( ForumDAO forumDAO ) {
        this.forumDAO = forumDAO;
    }

    @RequestMapping( path = "/forum", method = RequestMethod.GET )
    public List<ForumTopic> getAllForumTopicNames() {
        return forumDAO.getAllTopicNames();
    }

    @RequestMapping( path = "/forum/{topicID}", method = RequestMethod.GET )
    public List<TopicPost> getAllForumPostByTopic(@PathVariable int topicID ) {
        return forumDAO.getAllPostsByForumTopicId( topicID );
    }

}
