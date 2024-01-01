package com.web.springboot.service;

import com.web.springboot.dao.CommentDao;
import com.web.springboot.dao.PostDao;
import com.web.springboot.entity.Comment;
import com.web.springboot.entity.Mapper.PostWithCommentsVoConverter;
import com.web.springboot.entity.Post;
import com.web.springboot.entity.Vo.PostWithComments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.LongSummaryStatistics;

@Service
public class PostService {
    private final PostDao postDao;
    private final CommentDao commentDao;

    @Autowired
    public PostService(PostDao postDao, CommentDao commentDao) {
        this.postDao = postDao;
        this.commentDao = commentDao;
    }

    // 根据type返回帖子列表
    public ArrayList<PostWithComments> getPosts(Integer type) {
        List<Post> posts = postDao.findByType(type);
        ArrayList<PostWithComments> res = new ArrayList<>();
        for (Post post :
                posts) {
            Integer postId = post.getId();
            List<Comment> comments = commentDao.findByPostId(postId);
            PostWithComments postWithComments = PostWithCommentsVoConverter.convert(post, comments);
            res.add(postWithComments);
        }
        return res;

    }
}
