package com.sandrorjr.myBlog.DTO;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class PostDTO {
    private String title;
    private String writer;
    private List<UUID> tags;
    private String htmlContent;
}
