package com.web.springboot.entity.Vo;

import com.web.springboot.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostWithComments {
    private Long id;
    private String authorName;
    private String title;
    private Integer type;
    private String content;
    private List<CommentVo> commentsVo;

}
