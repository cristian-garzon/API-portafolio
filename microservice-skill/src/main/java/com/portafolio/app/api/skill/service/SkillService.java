package com.portafolio.app.api.skill.service;

import com.portafolio.app.api.skill.entity.Skill;

import java.util.List;
import java.util.Optional;

public interface SkillService {
    public List<Skill> list();
    public Skill save(Skill skill);
    public Optional<Skill> find(Long id);
    public void delete(Long id);
}
