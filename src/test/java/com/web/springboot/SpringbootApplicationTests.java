package com.web.springboot;

import com.web.springboot.controller.ResourceHandler;
import com.web.springboot.controller.UserHandler;
import com.web.springboot.entity.ResourceData;
import com.web.springboot.entity.User;
import com.web.springboot.init_opration.picture_init;
import com.web.springboot.repository.ResourceRepository;
import com.web.springboot.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@SpringBootTest
class SpringbootApplicationTests {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserHandler userHandler;
    @Autowired
    ResourceRepository resourceRepository;
    @Autowired
    ResourceHandler resourceHandler;
    @Autowired
    picture_init init;

    @Test
    void add_pic() {
        init.add_picture("人机交互", "C:\\Evr\\pic\\rjjh.jpg");
//
    }
//
//    @Test
//    void Register_test() {
//        User user = new User();
//        user.setUsername("xhh");
//        user.setPassword("12345");
//        user.setContribution(1);
//        String res = userHandler.Register(user);
//        System.out.println(res);
//    }
//
//    @Test
//    void Login_test_success() {
//        User user = new User();
//        user.setUsername("李东升");
//        user.setPassword("lds555");
//        String res = userHandler.Login(user);
//        System.out.println(res);
//    }
//
//    @Test
//    void Login_test_fail() {
//        User user = new User();
//        user.setUsername("李东升");
//        user.setPassword("lds5555");
//        String res = userHandler.Login(user);
//        System.out.println(res);
//    }
//
//    @Test
//    void Login_test_notexist() {
//        User user = new User();
//        user.setUsername("xxjj");
//        user.setPassword("lds5555");
//        String res = userHandler.Login(user);
//        System.out.println(res);
//    }
//
//    @Test
//    void Sort() {
//        List<UserHandler.rank_user> users = userHandler.Rank();
//        for (UserHandler.rank_user u :
//                users) {
//            System.out.println(u.getRank() + "  " + u.getUsername() + "  " + u.getContribution());
//        }
//    }

    /*@Test
    void upLoadFile() {
        String filePath = "/home/floveram/WEB/data/test_data/default_picture.webp";

        File file = new File(filePath);
        MultipartFile cMultiFile;
        try {
            cMultiFile = new MockMultipartFile("file", file.getName(), null, new FileInputStream(file));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
 //       ResourceData data = new ResourceData(cMultiFile, "互联网计算", "李东升", "wenjian", "nb");
 //       resourceHandler.uploadFile(data);

    }*/
}