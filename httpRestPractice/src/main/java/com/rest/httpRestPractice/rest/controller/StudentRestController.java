package com.rest.httpRestPractice.rest.controller;

import com.rest.httpRestPractice.rest.entity.Student;
import jakarta.annotation.PostConstruct;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;

    @PostConstruct
    public void loadData(){

        theStudents = new ArrayList<>();
        theStudents.add(new Student("Eduardo","Beitia"));
        theStudents.add(new Student("Victor","Ponce"));
        theStudents.add(new Student("Sebas","Castro"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){

        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudents(@PathVariable int studentId){

        if(studentId > theStudents.size() || studentId<0){
            throw new StudentNotFoundException("Student id not found: " + studentId);
        }

        return theStudents.get(studentId);
    }

}
