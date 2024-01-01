package com.web.springboot.dao;

import com.web.springboot.entity.Post;
import com.web.springboot.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostDao extends JpaRepository<Post,Integer> {
    //查询type类型的帖子
    List<Post> findByTypeOrderByTimeDesc(Integer type);
}
