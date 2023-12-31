package com.web.springboot.entity.Mapper;

import com.web.springboot.entity.Comment;
import com.web.springboot.entity.User;
import com.web.springboot.entity.Vo.CommentVo;
import com.web.springboot.repository.UserRepository;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

//将Comment转换为CommentVo
@Mapper
public class CommentVoConverter {
    private static UserRepository userRepository;
    @Autowired
    public CommentVoConverter(UserRepository userRepository){
        CommentVoConverter.userRepository =userRepository;
    }
    public static CommentVo convert(Comment comment){

        String userName = userRepository.findById(comment.getAuthorId()).map(User::getUsername).orElse("无名氏？");
        return CommentVo.builder()
                .id(comment.getId())
                .authorName(userName)
                .content(comment.getContent())
                .postId(comment.getPostId())
                .time(comment.getTime().toString())
                .build();
    }
}
