package com.web.springboot.controller;

import com.web.springboot.entity.Mapper.PostConverter;
import com.web.springboot.entity.Mapper.PostVoConverter;
import com.web.springboot.entity.Mapper.PostWithCommentsVoConverter;
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

    @GetMapping("/get_posts/{type}")
    public ResponseEntity<ArrayList<PostWithComments>> findAll(@PathVariable("type") Integer type) {
        return ResponseEntity.ok(postService.getPosts(type));
    }

    @PostMapping("/publish")
    public ResponseEntity<PostWithComments> publish(@RequestBody PostVo postVo) {
        if (postVo.getTitle().isEmpty() || postVo.getContent().isEmpty()) {
            return ResponseEntity.status(402).body(null);
        } else if (!userService.isUserExist(postVo.getAuthorName())) {
            return ResponseEntity.status(401).body(null);
        }
        return ResponseEntity.ok(
                PostWithCommentsVoConverter.convert(
                        postService.addPost(PostConverter.convert(postVo)),
                        new ArrayList<>())
        );
    }
}
