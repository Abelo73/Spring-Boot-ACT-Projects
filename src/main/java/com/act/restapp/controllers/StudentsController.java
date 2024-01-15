package com.act.restapp.controllers;

import com.act.restapp.models.Student;
import com.act.restapp.services.StudentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentsController {

    private final StudentsService studentsService;

    @PostMapping("/add/{sectionId}")
    public ResponseEntity<Student> addStudent(
            @PathVariable Long sectionId,
            @RequestBody Student student
    ){
        Student createdStudent = studentsService.createStudent(sectionId, student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students = studentsService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping("/assignToSection/{sectionId}")
    public ResponseEntity<Student> assignStudentToSection(
            @PathVariable Long sectionId,
            @RequestBody Student student
    ){
        Student assignedStudent = studentsService.assignStudentToSection(sectionId, student);
        return new ResponseEntity<>(assignedStudent, HttpStatus.CREATED);
    }

//    Deleting Student
    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long studentId) {
        try {
            studentsService.deleteStudent(studentId);
            return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting student: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
