package com.portafolio.app.api.skill.service;

import com.portafolio.app.api.skill.entity.Skill;
import com.portafolio.app.api.skill.repository.SkillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepo repo;

    @Override
    public List<Skill> list() {
        return repo.findAll();
    }

    @Override
    public Skill save(Skill skill) {
        return repo.save(skill);
    }

    @Override
    public Optional<Skill> find(Long id) {
        return repo.findById(id);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
