package com.sandrorjr.myBlog.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "TagOfPost")
@Data
public class TagOfPost {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_post")
    private PostModel post;
    @Enumerated(EnumType.STRING)
    private PostTagsEnum tag;

}
