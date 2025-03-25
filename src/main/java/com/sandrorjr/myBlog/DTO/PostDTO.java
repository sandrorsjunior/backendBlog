package com.sandrorjr.myBlog.DTO;

import lombok.Data;

import java.util.UUID;

@Data
public class PostDTO {
    private String title;
    private String writer;
    private UUID tags;
    private String htmlContent;
}
