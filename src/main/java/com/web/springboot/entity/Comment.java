package com.web.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
/**
 * 这是一个评论，包含评论的内容，作者id，帖子id，评论时间，评论id
 * */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer id;

    private Integer authorId;
    private String content;

    private Integer postId;

    private LocalDateTime time;
    private Integer commentId;
    public Comment(Integer postId,Integer authorId, String content){
        this.authorId=authorId;
        this.content=content;
        this.postId=postId;
        this.time=LocalDateTime.now();
    }
}
