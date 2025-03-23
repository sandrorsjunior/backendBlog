package com.sandrorjr.myBlog.controller;

import com.sandrorjr.myBlog.model.PostModel;
import com.sandrorjr.myBlog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("postArticle")
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public List<PostModel> getAllPost(){
        return postRepository.findAll();
    }

    @PostMapping
    public PostModel savePost(@RequestBody PostModel post){
        postRepository.save(post);
        return post;
    }
}
