package com.sandrorjr.myBlog.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "TagModel")
@Data
public class TagModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_post")
    @JsonIgnore
    private PostModel post;
    @Enumerated(EnumType.STRING)
    private PostTagsEnum tag;

}
