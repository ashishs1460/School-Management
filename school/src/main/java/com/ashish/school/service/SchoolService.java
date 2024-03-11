package com.ashish.school.service;

import com.ashish.school.client.StudentClient;
import com.ashish.school.entity.FullSchoolResponse;
import com.ashish.school.entity.School;
import com.ashish.school.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    private StudentClient studentClient;

    public void saveSchool(School school){
        schoolRepository.save(school);
    }

    public List<School> findAll(){
        return schoolRepository.findAll();
    }


    public FullSchoolResponse findSchoolsWithStudents(Integer schoolId) {
        System.out.println(schoolId +">>>>>>");
        var school = schoolRepository.findById(schoolId)
                .orElse(
                        School.builder()
                                .name("NOT_FOUND")
                                .email("NOT_FOUND")
                                .build()
                );
        var students = studentClient.findAllStudentsBySchool(schoolId);
        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
