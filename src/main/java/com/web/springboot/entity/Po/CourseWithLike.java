package com.web.springboot.entity.Po;

import com.web.springboot.entity.Course;
import com.web.springboot.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
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
    static public CourseWithLike covert(Course course,Boolean isLiked){
        return new CourseWithLike(course.getId(),course.getCoursename(),course.getTeachername(),course.getStudytime(),course.getViewtimes(),course.getIntroduction(),course.getDepartment(),course.getPicture(),isLiked);
    }
}
