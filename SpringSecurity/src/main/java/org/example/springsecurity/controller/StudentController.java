package org.example.springsecurity.controller;

import org.example.springsecurity.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {
    List<Student> students = new ArrayList<>(List.of(
            new Student(1, "John", 21),
            new Student(2, "Jimmy", 21),
            new Student(3, "Jane", 21),
            new Student(4, "Julius", 21),
            new Student(5, "William", 21)
    ));

    @GetMapping("/students")
    public ResponseEntity<List<Student>> index(){
        return ResponseEntity.ok().body(students);
    }

    @PostMapping("/students")
    public ResponseEntity<Map<String, String>> addStudent(@RequestBody Student student){
        students.add(student);
        return ResponseEntity.ok().body(Map.of("message", "Student added successfully!"));
    }
}
