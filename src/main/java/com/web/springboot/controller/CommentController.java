package com.web.springboot.controller;

import com.web.springboot.entity.Comment;
import com.web.springboot.entity.Mapper.CommentVoConverter;
import com.web.springboot.entity.Vo.CommentVo;
import com.web.springboot.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.web.springboot.service.UserService;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;
    private final UserService userService;

    @Autowired
    public CommentController(CommentService commentService, UserService userService) {
        this.commentService = commentService;
        this.userService = userService;
    }

    @PostMapping("/publish")
    public ResponseEntity<CommentVo> addComment(@RequestBody Comment comment) {
        if (!userService.isUserExist(comment.getAuthorId())) {
            return ResponseEntity.status(401).body(null);
        }
        return ResponseEntity.ok(CommentVoConverter.convert(commentService.addComment(comment)));
    }
}
