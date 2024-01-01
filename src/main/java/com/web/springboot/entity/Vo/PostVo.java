package com.web.springboot.entity.Vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.micrometer.common.lang.Nullable;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostVo {

    @Nullable
    private Integer id;

    private String title;
    private Integer type;
    private String content;
    private String authorName;
    private String time;
}
