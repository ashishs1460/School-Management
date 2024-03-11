package com.ashish.student.controller;

import com.ashish.student.entity.Student;
import com.ashish.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Student student){
        studentService.saveStudent(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAllStudents(){
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/school/{school-id}")
    public ResponseEntity<List<Student>> findStudentsBySchool(@PathVariable("school-id")
                                                              Integer schoolId){

        return ResponseEntity.ok(studentService.findAllStudentsBySchool(schoolId));
    }


}
