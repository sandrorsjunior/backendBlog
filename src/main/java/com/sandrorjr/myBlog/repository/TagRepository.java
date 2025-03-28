package com.sandrorjr.myBlog.repository;

import com.sandrorjr.myBlog.DTO.TagDTO;
import com.sandrorjr.myBlog.model.PostModel;
import com.sandrorjr.myBlog.model.TagModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TagRepository extends JpaRepository<TagModel, UUID> {
    public List<TagDTO> getAllTag();
}
