package com.sandrorjr.myBlog.repository;

import com.sandrorjr.myBlog.model.TagOfPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TagRepository extends JpaRepository<TagOfPost, UUID> {
}
