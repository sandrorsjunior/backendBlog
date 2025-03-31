package com.sandrorjr.myBlog.controller;

import com.sandrorjr.myBlog.model.SkillModel;
import com.sandrorjr.myBlog.repository.SkillRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("skill")
public class SkillController {
    @Autowired
    private SkillRepository skillRepository;

    @GetMapping
    public List<SkillModel> getAllSkill(){
        return this.skillRepository.findAll();
    }

    @GetMapping("/{id}")
    public SkillModel getSkillById(@PathVariable("id") UUID id){;
        return skillRepository.findById(id).orElse(null);
    }

    @PostMapping
    public SkillModel saveSkill(@RequestBody SkillModel skill){
        skillRepository.save(skill);
        return skill;
    }

    @PostMapping("/skills")
    public List<SkillModel> saveSkill(@RequestBody List<SkillModel> skill){
        skillRepository.saveAll(skill);
        return skill;
    }

    @DeleteMapping("/{id}")
    public UUID deleteSkillById(@PathVariable("id") UUID id){
        skillRepository.deleteById(id);
        return id;
    }

    @PutMapping("/{id}")
    public SkillModel updateSkill(@PathVariable("id") UUID id,
                                  @RequestBody SkillModel newSkill){
        newSkill.setId(id);
        skillRepository.save(newSkill);
        return newSkill;
    }
}
