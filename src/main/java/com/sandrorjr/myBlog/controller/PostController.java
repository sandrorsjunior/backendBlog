package com.sandrorjr.myBlog.controller;

import com.sandrorjr.myBlog.model.PostModel;
import com.sandrorjr.myBlog.model.TagModel;
import com.sandrorjr.myBlog.repository.PostRepository;
import com.sandrorjr.myBlog.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("postArticle")
public class PostController {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private TagRepository tagRepository;

    @GetMapping
    public List<PostModel> getAllPost(){
        return postRepository.findAll();
    }

    @PostMapping
    public PostModel savePost(@RequestBody PostModel post){
        postRepository.save(post);
        if(post.getTags() != null){
            for(TagModel tag: post.getTags()){
                tag.setPost(post);
                tagRepository.save(tag);
            }
            return post;
        }
        return null;
    }
}
