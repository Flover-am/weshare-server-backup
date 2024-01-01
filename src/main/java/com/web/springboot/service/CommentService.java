package com.web.springboot.service;

import com.web.springboot.dao.CommentDao;
import com.web.springboot.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final CommentDao commentDao;

    @Autowired
    public CommentService(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    public Comment addComment(Comment comment) {
        return commentDao.save(comment);
    }
}
