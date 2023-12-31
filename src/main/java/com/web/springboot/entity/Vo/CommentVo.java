package com.web.springboot.entity.Vo;

import lombok.Builder;

//Comment的VO类，用于返回给前端
@Builder
public class CommentVo {
    private Integer id;
    private String authorName;
    private String content;
    private Long postId;
    private String time;

}
