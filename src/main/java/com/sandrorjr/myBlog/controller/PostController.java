package com.sandrorjr.myBlog.controller;

import com.sandrorjr.myBlog.model.PostModel;
import com.sandrorjr.myBlog.repository.PostRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/postArticle")
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public List<PostModel> getAllPost(){
        return postRepository.findAll();
    }

    @GetMapping("{id}")
    public PostModel findPostById(@PathVariable("id") UUID id) {
        try{
            return this.searchPostById(id);
        } catch (ResponseStatusException e) {
            e.printStackTrace();
        }
        return null;

    }
    @PostMapping
    public PostModel savePost(@RequestBody PostModel post){
        postRepository.save(post);
        return post;
    }

    @PutMapping("/{id}")
    public PostModel updatePost(@PathVariable("id") UUID id, @RequestBody PostModel post) {
        try{
            PostModel oldPost = this.searchPostById(id);
            oldPost.setWriter(post.getWriter());
            oldPost.setTitle(post.getTitle());
            oldPost.setTags(post.getTags());
            oldPost.setHtmlContent(post.getHtmlContent());
            postRepository.save(oldPost);
            return oldPost;
        }catch (ResponseStatusException e){
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping("{id}")
    public UUID deletePost(@PathVariable("id") UUID id){
        postRepository.deleteById(id);
        return id;
    }

    public PostModel searchPostById(UUID id) throws ResponseStatusException {
        Optional<PostModel> post = postRepository.findById(id);
        if(post.isPresent()){
            return post.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with ID: " + id);
        }
    }
}
