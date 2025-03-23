package com.sandrorjr.myBlog.repository;

import com.sandrorjr.myBlog.model.SkillModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SkillRepository extends JpaRepository<SkillModel, UUID> {
}
