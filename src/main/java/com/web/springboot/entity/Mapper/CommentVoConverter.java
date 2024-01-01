package com.web.springboot.entity.Mapper;

import com.web.springboot.entity.Comment;
import com.web.springboot.entity.User;
import com.web.springboot.entity.Vo.CommentVo;
import com.web.springboot.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//将Comment转换为CommentVo
@Mapper
@Component
public class CommentVoConverter {
    @Autowired
    private UserRepository userRepository;

    public static CommentVoConverter INSTANCE;

    @PostConstruct
    public void init() {
        INSTANCE = this;
    }


    public static CommentVo convert(Comment comment) {

        String userName = INSTANCE.userRepository.findById(comment.getAuthorId()).map(User::getUsername).orElse("无名氏？");
        return CommentVo.builder()
                .id(comment.getId())
                .authorName(userName)
                .content(comment.getContent())
                .postId(comment.getPostId())
                .time(comment.getTime().toString())
                .build();
    }
}
