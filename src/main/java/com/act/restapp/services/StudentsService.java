package com.act.restapp.services;

import com.act.restapp.models.Sections;
import com.act.restapp.models.Student;
import com.act.restapp.models.StudentIdCard;
import com.act.restapp.repositories.SectionsRepositories;
import com.act.restapp.repositories.StudentIdCardRepositories;
import com.act.restapp.repositories.StudentRepositories;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentsService {

    private final StudentRepositories studentRepositories;
    private final SectionsRepositories sectionsRepositories;
    private final StudentIdCardRepositories studentIdCardRepositories;

    public Student createStudent(Long sectionId, Student student){
//        Check if The provided sections exists before saving
        Sections existingSection = sectionsRepositories.findById(sectionId)
                .orElseThrow(()-> new RuntimeException("Sections not Found"));
        student.setSections(existingSection);

        Student savedStudent = studentRepositories.save(student);

        StudentIdCard studentIdCard = new StudentIdCard();
        studentIdCard.setStudent(savedStudent);

        studentIdCardRepositories.save(studentIdCard);
        
        return studentRepositories.save(savedStudent);
    }


    @Transactional
    public List<Student> getAllStudents(){
        return studentRepositories.findAll();
    }

    public Student assignStudentToSection(Long sectionId, Student student) {
        return studentRepositories.save(student);
    }



    public void deleteStudent(Long studentId){
        Student student = studentRepositories.findById(studentId)
                .orElseThrow(()->new RuntimeException("Student Not Found"));

//        Delete Associated StudentIdCard
        StudentIdCard studentIdCard = student.getStudentIdCard();
        if (studentIdCard != null){
            studentIdCardRepositories.delete(studentIdCard);
        }

//        Delete the student
        studentRepositories.delete(student);

    }
}
