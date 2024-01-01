package com.web.springboot.controller;

import com.web.springboot.entity.Vo.PostWithComments;
import com.web.springboot.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;


    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/get_posts")
    public ArrayList<PostWithComments> findAll(@RequestParam Integer type) {
        return postService.getPosts(type);
    }

    @PostMapping("/publish")
    public String publish() {
        return "hello";
    }
}
