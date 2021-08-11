package com.portafolio.app.api.project.service;

import com.portafolio.app.api.project.entity.Images;
import com.portafolio.app.api.project.entity.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    public List<Project> list();
    public Project save(Project project);
    public Optional<Project> find(Long id);
    public Optional<Images> findImgByIdProject(Long id, Long id_img);
}
