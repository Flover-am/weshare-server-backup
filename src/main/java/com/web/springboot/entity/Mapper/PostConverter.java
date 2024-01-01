package com.web.springboot.entity.Mapper;

import com.web.springboot.entity.Vo.PostVo;
import com.web.springboot.repository.UserRepository;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.web.springboot.entity.Post;
@Mapper
@Component
public class PostConverter {

    private static UserRepository userRepository;

    @Autowired
    public PostConverter(UserRepository userRepository) {
        PostConverter.userRepository = userRepository;
    }
    public static Post convert(PostVo postVo) {
        Integer authorId = userRepository.findByUsername(postVo.getAuthorName()).getId();
        return Post.builder()
                .id(postVo.getId())
                .authorId(authorId)
                .title(postVo.getTitle())
                .type(postVo.getType())
                .content(postVo.getContent())
                .build();
    }
}
