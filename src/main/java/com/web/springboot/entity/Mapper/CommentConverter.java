package com.web.springboot.entity.Mapper;

import com.web.springboot.entity.Comment;
import com.web.springboot.entity.Vo.CommentVo;
import com.web.springboot.repository.UserRepository;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Mapper
@Component
public class CommentConverter {


    private static UserRepository userRepository;

    @Autowired
    public CommentConverter(UserRepository userRepository) {
        CommentConverter.userRepository = userRepository;
    }


    public static Comment convert(CommentVo commentVo) {
        Integer authorId = userRepository.findByUsername(commentVo.getAuthorName()).getId();
        return Comment.builder()
                .id(commentVo.getId())
                .authorId(authorId)
                .content(commentVo.getContent())
                .postId(commentVo.getPostId())
                .build();
    }
}
