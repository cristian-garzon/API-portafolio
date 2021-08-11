package com.portafolio.app.api.project.repository;

import com.portafolio.app.api.project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, Long> {
}
