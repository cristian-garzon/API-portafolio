package com.portafolio.app.api.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String urlRepo;

    private String description;

    @JsonIgnoreProperties(value = {"project"}, allowSetters = true)
    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Images> images;

    public Project(){
        this.images = new ArrayList<>();
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    public void addImages(Images images){
        this.images.add(images);
        images.setProject(this);
    }
    public void removeImages(Images images){
        this.images.remove(images);
    }
    public List<Images> getImages() {
        return images;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUrlRepo(String urlRepo) {
        this.urlRepo = urlRepo;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getUrlRepo() {
        return urlRepo;
    }

    public String getDescription() {
        return description;
    }

}
