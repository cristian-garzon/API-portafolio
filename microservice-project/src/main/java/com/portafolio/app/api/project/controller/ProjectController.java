package com.portafolio.app.api.project.controller;

import com.portafolio.app.api.project.entity.Images;
import com.portafolio.app.api.project.entity.Project;
import com.portafolio.app.api.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService service;

    @GetMapping("/list")
    public ResponseEntity<?> list(){
        return ResponseEntity.ok(service.list());
    }
    @PostMapping("/save")
    public ResponseEntity<?> save(Project project, @RequestParam MultipartFile file) throws IOException{
        Images images = new Images();
        images.setImage(file.getBytes());
        images.setProject(project);
        if(!file.isEmpty()) project.addImages(images);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(project));
    }
    @PutMapping("/add_image/{id}")
    public ResponseEntity<?> addImage(@PathVariable Long id, @RequestParam MultipartFile file) throws IOException{
        Project project = service.find(id).get();
        Images images = new Images();
        images.setImage(file.getBytes());
        images.setProject(project);
        if(!file.isEmpty()) project.addImages(images);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(project));
    }

}
