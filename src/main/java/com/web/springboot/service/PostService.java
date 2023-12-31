package com.web.springboot.service;

import com.web.springboot.dao.CommentDao;
import com.web.springboot.dao.PostDao;
import com.web.springboot.entity.Vo.PostWithComments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostService {
    private final PostDao postDao;
    private final CommentDao commentDao;

    @Autowired
    public PostService(PostDao postDao, CommentDao commentDao) {
        this.postDao = postDao;
        this.commentDao = commentDao;
    }

    @GetMapping("/get_posts")
    public PostWithComments getPosts() {
        return null;
    }
}
