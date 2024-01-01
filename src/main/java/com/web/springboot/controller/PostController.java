package com.web.springboot.controller;

import com.web.springboot.entity.Mapper.PostVoConverter;
import com.web.springboot.entity.Post;
import com.web.springboot.entity.Vo.PostVo;
import com.web.springboot.entity.Vo.PostWithComments;
import com.web.springboot.service.PostService;
import com.web.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;
    private final UserService userService;

    @Autowired
    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping("/get_posts")
    public ArrayList<PostWithComments> findAll(@RequestParam Integer type) {
        return postService.getPosts(type);
    }

    @PostMapping("/publish")
    public ResponseEntity<PostVo> publish(@RequestBody Post post) {
        if (post.getTitle().isEmpty() || post.getContent().isEmpty()) {
            return ResponseEntity.status(402).body(null);
        } else if (!userService.isUserExist(post.getAuthorId())) {
            return ResponseEntity.status(401).body(null);
        }
        return ResponseEntity.ok(PostVoConverter.convert(postService.addPost(post)));
    }
}
