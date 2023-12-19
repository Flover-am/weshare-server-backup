package com.web.springboot.controller;

import com.web.springboot.entity.Course;
import com.web.springboot.repository.CourseRepository;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseHandler {
    @Autowired
    private CourseRepository courseRepository;
    private final Logger logger = LoggerFactory.getLogger(CourseHandler.class);

    /**
     * 访问所有课程信息
     * 并返回一个列表
     * 将此接口映射为url
     *
     * @return 装有所有课程信息的列表
     */
    @GetMapping("/findAll")
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @GetMapping("/findAllName")
    public List<Course> findAllName() {
        List<Course> get = courseRepository.findAll();

        for (Course c :
                get) {
            c.setPicture(new byte[1]);
        }

        return get;
    }


    /**
     * 对课程进行弱模糊搜索
     * 并返回一个列表
     * 搜索模式：匹配关键字{name}，关键字必须完整
     * url:/findByName/{name}
     *
     * @return 匹配到的课程列表
     */
    @GetMapping("/findByName/{name}")
    public List<Course> findByCoursename(@PathVariable("name") String name) {
        return courseRepository.findByCoursenameLike("%" + name + "%");
    }

    /**
     * 根据课程名称获取课程的图片
     * url："/getpicture/{coursename}"
     *
     * @param response：内存有图片的二进制流
     * @param coursename          课程名称
     * @return "coures_not_exist":课程不存在
     * "fail":后端获取文件失败
     * "success":获取成功
     */
    @GetMapping("/getpicture/{coursename}")
    public String getPicture(HttpServletResponse response, @PathVariable("coursename") String coursename) {
        Course course = courseRepository.findByCoursename(coursename);
        if (course == null) {
            logger.warn("请求了不存在课程的图片文件，请求课程名：" + coursename);
            return "course_not_exist";
        }
        byte[] picture = course.getPicture();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(picture);
        response.reset();
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Disposition", "attachment;coursename=" + coursename);

        BufferedInputStream bis = new BufferedInputStream(byteArrayInputStream);
        try {
            byte[] buff = new byte[1024];
            OutputStream os = response.getOutputStream();
            int i;
            while ((i = bis.read(buff)) != -1) {
                os.write(buff, 0, i);
                os.flush();
            }
        } catch (IOException e) {
            logger.error("获取图片失败");
            return "fail";
        }
        return "success";
    }

    /**
     * 根据课程id查找课程名
     *
     * @param id 课程id
     * @return 课程名；若课程id不存在，则返回error
     */
    @GetMapping("/findCourseNameById/{id}")
    public String findCourseNameById(@PathVariable("id") int id) {
        Course course = courseRepository.findById(id);
        if (course == null) {
            return "error";
        } else {
            return course.getCoursename();
        }
    }
}
