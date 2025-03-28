package com.sandrorjr.myBlog.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TagModel")
@Data
public class TagModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToMany(mappedBy = "tags")
    @JsonIgnore
    private List<PostModel> post;
    @Enumerated(EnumType.STRING)
    private PostTagsEnum tag;

    public void addPost(PostModel post){
        if(this.getPost()==null){
            this.setPost(new ArrayList<PostModel>());
        }
        this.post.add(post);
    }
}
