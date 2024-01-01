package com.web.springboot.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Blob;
import java.util.List;

/**
 * 课程实体类
 */
@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String coursename;
    private String teachername;
    private String studytime;
    private Integer viewtimes;
    private String introduction;
    private String department;
    @Column(name = "picture", columnDefinition = "mediumblob")
    private byte[] picture;

    private String pictureUrl;

    @ManyToMany
    @JoinTable(name = "likes", joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private List<User> userList;

    /**
     * @return 将对象所有信息以String方式返回
     */
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
