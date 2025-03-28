package com.sandrorjr.myBlog.DTO;

import lombok.Data;

import java.util.List;
import java.util.UUID;
@Data
public class PostClean {
    private UUID id;
    private String title;
    private String writer;
}

