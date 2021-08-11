package com.portafolio.app.api.project.repository;

import com.portafolio.app.api.project.entity.Images;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagesRepo extends JpaRepository<Images, Long> {
}
