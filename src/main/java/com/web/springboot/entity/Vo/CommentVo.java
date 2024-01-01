package com.web.springboot.entity.Vo;

import lombok.Builder;
import lombok.Data;

//Comment的VO类，用于返回给前端
@Builder
@Data
public class CommentVo {
    private Integer id;
    private String authorName;
    private String content;
    private Integer postId;
    private String time;

}
