package com.web.springboot.entity.Vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.web.springboot.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostWithComments {
    private Integer id;
    private String authorName;
    private String title;
    private String type;
    private String content;
    private List<CommentVo> commentsVo;

}
