package com.web.springboot.repository;

import com.web.springboot.entity.likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface likesRepository extends JpaRepository<likes, Integer> {

    @Query(value = "select * from likes where course_id=?1 and user_id=?2", nativeQuery = true)
    List<likes> findByCourseIdAndUserId(Integer courseId, Integer userId);
}
