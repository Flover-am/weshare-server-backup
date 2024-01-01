package com.web.springboot.service;

import com.web.springboot.dao.CommentDao;
import com.web.springboot.dao.PostDao;
import com.web.springboot.entity.Comment;
import com.web.springboot.entity.Mapper.PostWithCommentsVoConverter;
import com.web.springboot.entity.Post;
import com.web.springboot.entity.Vo.PostWithComments;
import com.web.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private final PostDao postDao;
    private final CommentDao commentDao;
    private final UserRepository userDao;

    @Autowired
    public PostService(PostDao postDao, CommentDao commentDao, UserRepository userDao) {
        this.postDao = postDao;
        this.commentDao = commentDao;
        this.userDao = userDao;
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

    public Post addPost(Post post) {
        return postDao.save(post);
    }
}
