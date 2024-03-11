package com.ashish.school.controller;

import com.ashish.school.entity.FullSchoolResponse;
import com.ashish.school.entity.School;
import com.ashish.school.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody School school){

        schoolService.saveSchool(school);
    }

    @GetMapping
    public ResponseEntity<List<School>> findAllStudents(){
        return ResponseEntity.ok(schoolService.findAll());
    }

    @GetMapping("/with-students/{school-id}")
    public ResponseEntity<FullSchoolResponse> findAllStudents(@PathVariable("school-id") Integer schoolId){
        System.out.println(schoolId);
        return ResponseEntity.ok(schoolService.findSchoolsWithStudents(schoolId));
    }
}
