package com.sandrorjr.myBlog.controller;

import com.sandrorjr.myBlog.dto.responseProject;
import com.sandrorjr.myBlog.model.ProjectModel;
import com.sandrorjr.myBlog.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("project")
public class ProjectController {
    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping
    public List<responseProject> getAllProject(){
        List<responseProject> response = new ArrayList<>();
        for(ProjectModel  project: projectRepository.findAll()){
            responseProject responseItem = new responseProject(
                    project.getId(),
                    project.getLogoSrc(),
                    project.getTitle(),
                    project.getDescription(),
                    project.getPost().getId(),
                    project.getDataCadastro(),
                    project.getDataAtualizacao()
            );
            response.add(responseItem);
        }
        return response;
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
    @PostMapping("projects")
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
