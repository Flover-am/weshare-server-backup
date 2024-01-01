package com.web.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

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

    // 要传递的：作者id，帖子id，评论内容
    private Integer authorId;
    private Integer postId;
    private String content;


    // 评论时间自动生成
    @CreationTimestamp
    private LocalDateTime time;

}
