package com.web.springboot.repository;

import com.web.springboot.entity.Course;
import jakarta.annotation.Nullable;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    @Nullable
    List<Course> findByCoursenameLike(String coursename);
    Course findByCoursename(String coursename);

    Course findById(int id);
}
