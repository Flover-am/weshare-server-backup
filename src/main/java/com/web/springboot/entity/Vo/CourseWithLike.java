package com.web.springboot.entity.Vo;

import com.web.springboot.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseWithLike {
    private Integer id;
    private String coursename;
    private String teachername;
    private String studytime;
    private Integer viewtimes;
    private String introduction;
    private String department;
    private byte[] picture;
    private Boolean isLiked;
    private String pictureUrl;

    static public CourseWithLike covert(Course course, Boolean isLiked) {
        return new CourseWithLike(course.getId(), course.getCoursename(), course.getTeachername(), course.getStudytime(), course.getViewtimes(), course.getIntroduction(), course.getDepartment(), course.getPicture(), isLiked, course.getPictureUrl());
    }
}
