package com.web.springboot.service;

import com.web.springboot.entity.Resource;
import com.web.springboot.repository.ResourceRepository;
import com.web.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {

    private final ResourceRepository resourceRepository;

    private final UserRepository userRepository;

    @Autowired
    public ResourceService(ResourceRepository resourceRepository, UserService userService, UserRepository userRepository) {
        this.resourceRepository = resourceRepository;
        this.userRepository = userRepository;
    }

    // 删除资源
    public void deleteResource(Integer id) {
        resourceRepository.deleteById(id);
    }

    public List<Resource> findMyResource(String userName) {
        Integer userId = userRepository.findByUsername(userName).getId();
        return resourceRepository.findByUploaderid(userId);
    }

}
