package com.web.springboot.repository;

import com.web.springboot.entity.User;
import org.junit.jupiter.api.Test;
import com.web.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

//    @Test
    void findbyusername() {

        User user = userRepository.findByUsername("李东升");
        System.out.printf(user.getPassword());
    }
}