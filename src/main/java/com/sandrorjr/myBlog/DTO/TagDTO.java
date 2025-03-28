package com.sandrorjr.myBlog.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sandrorjr.myBlog.model.PostModel;
import com.sandrorjr.myBlog.model.PostTagsEnum;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

public class TagDTO {
    private List<PostClean> titleOfPosts;
    private PostTagsEnum tag;
}
