package com.web.springboot.controller;

import com.web.springboot.entity.Resource;
import com.web.springboot.entity.User;
import com.web.springboot.repository.ResourceRepository;
import com.web.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.*;


import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserRepository userRepository;

    /**
     * 用户注册
     * url:"/user/register"
     *
     * @param user_data1 : 内为username 和 password两个字段
     * @return 字符串String
     * 用户已存在 返回 “exist”
     * 注册成功 返回 "success"
     */
    @PostMapping("/register")
    public String Register(@RequestBody User user_data1) {
        User user_data = userRepository.findByUsername(user_data1.getUsername());
        if (user_data != null) {
            return "exist";
        }
        user_data1.setContribution(0);
        User receive1 = userRepository.save(user_data1);
        return "success";
    }

    /**
     * 用户登录
     * url:"/user/login"
     *
     * @param user_data_receive : 内为username 和 password两个字段
     * @return 字符串String
     * 用户不存在 返回 “not exist”
     * 登录成功 返回 “success”
     * 密码不对 返回 “fail”
     */
    @PostMapping("/login")
    public String Login(@RequestBody User user_data_receive) {
        User user_data = userRepository.findByUsername(user_data_receive.getUsername());
        if (user_data == null) {
            return "not exist";
        } else {
            boolean find = user_data_receive.getPassword().equals(user_data.getPassword());
            if (find) {
                return "success";
            } else {
                return "fail";
            }
        }
    }

    /**
     * 检查修改密码时，用户输入密码是否正确
     *
     * @param user_data_receive 包含用户名，用户输入的待检查密码
     * @return 字符串String
     *         若该用户不存在，返回error
     *         若密码正确，返回true
     *         若密码错误，返回false
     */
    @PostMapping("/modify/check")
    public String checkPasswd(@RequestBody User user_data_receive) {
        User user = userRepository.findByUsername(user_data_receive.getUsername());
        if (user == null) {
            return "error";
        }
        if (user.getPassword().equals(user_data_receive.getPassword())){
            return "true";
        } else {
            return "false";
        }
    }
    /**
     * 用户修改密码
     * url:"/modify/passwd"
     *
     * @param user_data_receive 包含新密码的用户数据（即 用户名+新密码）
     * @return 字符串String
     * 用户不存在 返回 “not exist”
     * 修改成功 返回 “success”
     * 修改失败 返回 “fail”
     */
    @PostMapping("/modify/passwd")
    @Modifying
    public String modifyPasswd(@RequestBody User user_data_receive) {
        User user = userRepository.findByUsername(user_data_receive.getUsername());
        if (user == null) {
            return "not exist";
        } else {
            user.setPassword(user_data_receive.getPassword());
            userRepository.save(user);
            user = userRepository.findByUsername(user_data_receive.getUsername());
            if (user.getPassword().equals(user_data_receive.getPassword())) {
                return "success";
            } else {
                return "fail";
            }
        }
    }

    /**
     * 用户贡献度排行榜获取
     * URL="/user/rank"
     *
     * @return 返回一个列表 ，按照贡献度降序，存贮每个用户的信息，可自行取出username和contribution字段 以及排名rank字段
     */
    @GetMapping("/rank")
    public List<rank_user> Rank() {
        List<User> users = userRepository.findByUsernameLikeOrderByContributionDesc("%");
        RankUsers rankUsers = new RankUsers(users);
        return rankUsers.getRank_userList();
    }

    /**
     * 将 List<user> 加上排名的方法类
     */
    private class RankUsers {
        List<rank_user> rank_userList = new LinkedList<>();

        public RankUsers(List<User> userList) {
            int rank = 1;
            for (User u :
                    userList) {
                rank_user one = new rank_user(u, rank++);

                rank_userList.add(one);
            }
        }

        public List<rank_user> getRank_userList() {
            return rank_userList;
        }
    }

    /**
     * 带有排名的user类
     */
    public class rank_user extends User {
        private int rank;

        public int getRank() {
            return rank;
        }

        public rank_user(User user, int rank_in) {
            rank = rank_in;
            this.setUsername(user.getUsername());
            this.setContribution(user.getContribution());
        }
    }

    /**
     * 根据用户名获取贡献值
     * url:"/getContrib/{username}"
     *
     * @param username 用户名
     * @return 其贡献值
     */
    @GetMapping("/getContrib/{username}")
    public int findContributionByUsername(@PathVariable("username") String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return user.getContribution();
        }
        return -1;
    }
}
