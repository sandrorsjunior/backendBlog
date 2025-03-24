package com.sandrorjr.myBlog.controller;

import com.sandrorjr.myBlog.model.TagModel;
import com.sandrorjr.myBlog.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tag")
public class TagController {
    @Autowired
    private TagRepository tagRepository;

    @GetMapping
    public List<TagModel> getAllTag(){
        return tagRepository.findAll();
    }
    /*@PostMapping
    public TagModel saveTag(TagModel tag){
        tagRepository.save(tag);
        return tag;
    }*/
    @PostMapping
    public List<TagModel> saveTag(List<TagModel> tags){
        tagRepository.saveAll(tags);
        return tags;
    }
}
