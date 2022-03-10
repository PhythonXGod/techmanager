package com.tehnika.tehnikamanager.repo;

import com.tehnika.tehnikamanager.model.Tech;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechRepo extends JpaRepository<Tech, Long> {
    void deleteTechById(Long id);
}
