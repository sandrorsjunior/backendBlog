package com.sandrorjr.myBlog.controller;

import com.sandrorjr.myBlog.DTO.TagDTO;
import com.sandrorjr.myBlog.model.PostModel;
import com.sandrorjr.myBlog.model.ProjectModel;
import com.sandrorjr.myBlog.model.TagModel;
import com.sandrorjr.myBlog.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("tag")
public class TagController {
    @Autowired
    private TagRepository tagRepository;

    @GetMapping
    public List<TagDTO> getAllTag(){
        return tagRepository.getAllTag();
    }


    @GetMapping("/{id}")
    public TagModel getTagById(@PathVariable("id") UUID id){;
        return tagRepository.findById(id).orElse(null);
    }


    @PostMapping
    public List<TagModel> saveTag(@RequestBody List<TagModel> tags){
        tagRepository.saveAll(tags);
        return tags;
    }

    @PutMapping("/{id}")
    public TagModel updateTag(@PathVariable("id") UUID id, @RequestBody TagModel tag){
        tag.setId(id);
        tagRepository.save(tag);
        return tag;
    }

    @DeleteMapping("/{id}")
    public UUID deleteTag(@PathVariable("id") UUID id){
        tagRepository.deleteById(id);
        return id;
    }

}
