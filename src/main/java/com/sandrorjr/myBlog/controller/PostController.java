package com.sandrorjr.myBlog.controller;

import com.sandrorjr.myBlog.DTO.PostDTO;
import com.sandrorjr.myBlog.model.PostModel;
import com.sandrorjr.myBlog.model.TagModel;
import com.sandrorjr.myBlog.repository.PostRepository;
import com.sandrorjr.myBlog.repository.TagRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @GetMapping("{id}")
    public PostModel findPostById(@PathParam("id") UUID id) throws Exception {
        Optional<PostModel> post = postRepository.findById(id);
        if(post.isPresent()){
            return post.get();
        }else{
            throw new Exception("shit");
        }
    }
    @PostMapping
    public PostModel savePost(@RequestBody PostDTO post){
        PostModel newPost = new PostModel();
        newPost.setId(UUID.randomUUID());
        newPost.setTitle(post.getTitle());
        newPost.setWriter(post.getWriter());
        newPost.setHtmlContent(post.getHtmlContent());
        try {
            TagModel tag = tagRepository.findById(post.getTags()).orElse(null);
            if(tag == null){
                System.out.println("shit");
                return null;
            }
            newPost.addTags(tag);
            postRepository.save(newPost);
            return newPost;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @PutMapping("/{id}")
    public PostModel updatePost(@PathVariable("id") UUID id, @RequestBody PostModel post) {
        try{
            PostModel postSaved = this.findPostById(id);
            post.setId(id);
            postRepository.save(post);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping("{id}")
    public UUID deletePost(@PathVariable("id") UUID id){
        postRepository.deleteById(id);
        return id;
    }
}
