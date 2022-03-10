package com.tehnika.tehnikamanager.service;

import com.tehnika.tehnikamanager.model.Tech;
import com.tehnika.tehnikamanager.repo.TechRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

//crud lietas
@Service
@Transactional
public class TechService {
    private final TechRepo techRepo;

    @Autowired
    public TechService(TechRepo techRepo) { this.techRepo = techRepo; }

    public List<Tech> findAllTech() {
        return techRepo.findAll();
    }

    public Tech updateTech(Tech tech) {
        return techRepo.save(tech);
    }

    public void deleteTech(Long id) {
        techRepo.deleteTechById(id);
    }

    public Tech addTech(Tech tech) {
        tech.setTechCode(UUID.randomUUID().toString());
        return techRepo.save(tech);
    }
}
