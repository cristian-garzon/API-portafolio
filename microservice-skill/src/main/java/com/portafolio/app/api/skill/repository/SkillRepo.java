package com.portafolio.app.api.skill.repository;

import com.portafolio.app.api.skill.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepo extends JpaRepository<Skill, Long> {
}
