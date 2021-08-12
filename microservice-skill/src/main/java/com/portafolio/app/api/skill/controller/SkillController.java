package com.portafolio.app.api.skill.controller;

import com.portafolio.app.api.skill.entity.Skill;
import com.portafolio.app.api.skill.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.module.ResolutionException;

@RestController
public class SkillController {

    @Autowired
    private SkillService service;

    @GetMapping("/list")
    public ResponseEntity<?> list(){
        return ResponseEntity.ok().body(service.list());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> find(@PathVariable Long id){
        return (service.find(id).get() != null) ? ResponseEntity.ok().body(service.find(id).get()) : ResponseEntity.notFound().build();
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(Skill skill, @RequestParam MultipartFile file) throws IOException {
        if (!file.isEmpty()) skill.setImage(file.getBytes());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(skill));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/show_image/{id}")
    public ResponseEntity<?> showImage(@PathVariable Long id){
        Skill skill = service.find(id).get();
        if(skill.getImage() == null) return ResponseEntity.noContent().build();
        Resource img = new ByteArrayResource(skill.getImage());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(img);
    }


}
