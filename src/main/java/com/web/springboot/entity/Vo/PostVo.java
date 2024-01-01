package com.web.springboot.entity.Vo;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PostVo {

    private Integer id;

    private String title;
    private Integer type;
    private String content;
    private String authorName;
}
