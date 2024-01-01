package com.web.springboot.service;

import com.web.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userDao;

    @Autowired
    public UserService(UserRepository userDao) {
        this.userDao = userDao;
    }

    // 判断用户是否存在
    public boolean isUserExist(String userName) {
        return userDao.existsByUsername(userName);
    }
}
