package com.portafolio.app.api.project.repository;

import com.portafolio.app.api.project.entity.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ImagesRepo extends JpaRepository<Images, Long> {

    @Query("select i from Images i join fetch i.project p  where i.id=?2 and p.id=?1")
    public Optional<Images> findImgByIdProject(Long id, Long id_img);
}
