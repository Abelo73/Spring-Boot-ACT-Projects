package com.act.restapp.repositories;

import com.act.restapp.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;



public interface StudentRepositories extends JpaRepository<Student, Long> {

}
