package com.web.springboot.entity.Mapper;

import com.web.springboot.entity.Post;
import com.web.springboot.entity.Vo.PostVo;
import com.web.springboot.repository.UserRepository;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.web.springboot.entity.User;

import java.time.format.DateTimeFormatter;

@Mapper
@Component
public class PostVoConverter {

    private static UserRepository userRepository;

    @Autowired
    public PostVoConverter(UserRepository userRepository) {
        PostVoConverter.userRepository = userRepository;
    }

    public static PostVo convert(Post post) {
        String userName = userRepository.findById(post.getAuthorId()).map(User::getUsername).orElse("无名氏？");
        return PostVo.builder()
                .id(post.getId())
                .authorName(userName)
                .title(post.getTitle())
                .type(post.getType())
                .content(post.getContent())
                .time(post.getTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .build();
    }


}
