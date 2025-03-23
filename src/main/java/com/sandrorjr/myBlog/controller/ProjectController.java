package com.sandrorjr.myBlog.controller;

import com.sandrorjr.myBlog.model.ProjectModel;
import com.sandrorjr.myBlog.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("project")
public class ProjectController {
    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping
    public List<ProjectModel> getAllProject(){
        return projectRepository.findAll();
    }

    @GetMapping("/{id}")
    public ProjectModel getProjectById(@PathVariable("id") UUID id){;
        return projectRepository.findById(id).orElse(null);
    }
    @PostMapping
    public ProjectModel saveProject(@RequestBody ProjectModel project){
        projectRepository.save(project);
        return project;
    }

    @PutMapping("/{id}")
    public ProjectModel saveProject(@PathVariable("id") UUID id,
                                    @RequestBody ProjectModel project){
        project.setId(id);
        projectRepository.save(project);
        return project;
    }
    @PostMapping
    public List<ProjectModel> saveProject(@RequestBody List<ProjectModel> project){
        projectRepository.saveAll(project);
        return project;
    }
    @DeleteMapping("/{id}")
    public UUID deleteProjectById(@PathVariable("id") UUID id){
        projectRepository.deleteById(id);
        return id;
    }
}
