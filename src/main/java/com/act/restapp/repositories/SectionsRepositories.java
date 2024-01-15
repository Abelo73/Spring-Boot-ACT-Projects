package com.act.restapp.repositories;

import com.act.restapp.models.Sections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionsRepositories extends JpaRepository<Sections, Long> {
}
