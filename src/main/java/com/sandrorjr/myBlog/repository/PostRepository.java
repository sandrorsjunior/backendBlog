package com.sandrorjr.myBlog.repository;

import com.sandrorjr.myBlog.model.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostRepository extends JpaRepository<PostModel, UUID> {
}
