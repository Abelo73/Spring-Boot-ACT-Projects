package com.act.restapp.repositories;

import com.act.restapp.models.StudentIdCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentIdCardRepositories extends JpaRepository<StudentIdCard, Long> {
}
