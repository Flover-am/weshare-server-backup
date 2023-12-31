package com.web.springboot.dao;

import com.web.springboot.entity.Post;
import com.web.springboot.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDao extends JpaRepository<Post,Integer> {

}
