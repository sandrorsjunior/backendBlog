package com.sandrorjr.myBlog.repository;

import com.sandrorjr.myBlog.model.ProjectModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjectRepository extends JpaRepository<ProjectModel, UUID> {
}
