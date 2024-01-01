package com.web.springboot.dao;

import com.web.springboot.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao extends JpaRepository<Comment,Integer> {
    // 根据postId查询评论
    List<Comment> findByPostId(Integer postId);
}
