package com.portafolio.app.api.project.service;

import com.portafolio.app.api.project.entity.Images;
import com.portafolio.app.api.project.entity.Project;
import com.portafolio.app.api.project.repository.ImagesRepo;
import com.portafolio.app.api.project.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService{


    @Autowired
    private ProjectRepo repo;

    @Autowired
    private ImagesRepo imagesRepo;


    @Override
    public List<Project> list() {
        return repo.findAll();
    }

    @Override
    public Project save(Project project) {
        return repo.save(project);
    }

    @Override
    public Optional<Project> find(Long id) {
        return repo.findById(id);
    }

    @Override
    public Optional<Images> findImgByIdProject(Long id, Long id_img) {
        return imagesRepo.findImgByIdProject(id, id_img);
    }

    @Override
    public Date parseDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date dateFormat = null;
        try {
            dateFormat = format.parse(date);
        } catch (ParseException e){
            System.out.println(e.getMessage());
        }
        return dateFormat;
    }
}
