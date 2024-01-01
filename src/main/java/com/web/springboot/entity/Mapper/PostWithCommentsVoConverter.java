package com.web.springboot.entity.Mapper;

import com.web.springboot.entity.Comment;
import com.web.springboot.entity.Post;
import com.web.springboot.entity.User;
import com.web.springboot.entity.Vo.PostWithComments;
import com.web.springboot.repository.UserRepository;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

// 将Post和List<Comment>转换为PostWithComments
@Mapper
@Component
public class PostWithCommentsVoConverter {

    private static UserRepository userRepository;

    @Autowired
    public PostWithCommentsVoConverter(UserRepository userRepository) {
        PostWithCommentsVoConverter.userRepository = userRepository;
    }
    /*type = 1,2,3 转换成 技术，资源，闲聊*/
    static String Type(Integer type) {
        switch (type) {
            case 1:
                return "技术";
            case 2:
                return "资源";
            case 3:
                return "闲聊";
            default:
                return "未知";
        }
    }

    public static PostWithComments convert(Post post, List<Comment> comments) {
        String userName = userRepository.findById(post.getAuthorId()).map(User::getUsername).orElse("无名氏？");
        return PostWithComments.builder()
                .id(post.getId())
                .authorName(userName)
                .title(post.getTitle())
                /*type = 1,2,3 对应着技术，资源，闲聊*/
                .type(Type(post.getType()))
                .content(post.getContent())
                .commentsVo(comments.stream().map(CommentVoConverter::convert).collect(Collectors.toList()))
                .build();
    }


}
