package com.web.springboot.entity.Mapper;

import com.web.springboot.entity.Comment;
import com.web.springboot.entity.Post;
import com.web.springboot.entity.User;
import com.web.springboot.entity.Vo.PostWithComments;
import com.web.springboot.repository.UserRepository;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

// 将Post和List<Comment>转换为PostWithComments
@Mapper
public class PostWithCommentsVoConverter {

    private static UserRepository userRepository;

    @Autowired
    public PostWithCommentsVoConverter(UserRepository userRepository) {
        PostWithCommentsVoConverter.userRepository = userRepository;
    }

    public static PostWithComments convert(Post post, List<Comment> comments) {
        String userName = userRepository.findById(post.getAuthorId()).map(User::getUsername).orElse("无名氏？");
        return PostWithComments.builder()
                .id(post.getId())
                .authorName(userName)
                .title(post.getTitle())
                .type(post.getType())
                .content(post.getContent())
                .commentsVo(comments.stream().map(CommentVoConverter::convert).collect(Collectors.toList()))
                .build();
    }


}
