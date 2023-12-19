package com.web.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 点赞实体类
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class likes {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer id;
    private Integer course_id;
    private Integer user_id;
    public likes(Integer course_id, Integer user_id){
        this.course_id=course_id;
        this.user_id=user_id;
    }

}
