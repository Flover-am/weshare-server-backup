package com.web.springboot.controller;

import com.web.springboot.entity.User;
import com.web.springboot.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserHandlerTest {
    @Autowired
    UserHandler userHandler = new UserHandler();

    @Autowired
    UserRepository userRepository;

//    @Test
    void modifyPasswdTest(){
        User user = new User();
        user.setUsername("114");
        user.setPassword("1145145");
        System.out.println(userHandler.modifyPasswd(user));
    }

//    @Test
    void checkPasswdTest() {
        User user = new User();
        user.setUsername("114");
        user.setPassword("1145145");
        System.out.println(userHandler.checkPasswd(user));
        user.setPassword("114514");
        System.out.println(userHandler.checkPasswd(user));
    }

//    @Test
    void getContribTest() {
        System.out.println(userHandler.findContributionByUsername("114"));
    }

}