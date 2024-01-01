package com.web.springboot.repository;

import com.web.springboot.entity.User;
import jakarta.annotation.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Nullable
    User findByUsername(String userName);

    List<User> findByUsernameLikeOrderByContributionDesc(String name);

    @Transactional
    @Modifying
    @Query("update User u set u.password = ?1 where u.username = ?2")
    int updatePasswordByUsername(String password, String username);


    @Nullable
    User findById(int id);

}
