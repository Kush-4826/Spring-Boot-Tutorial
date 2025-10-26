package org.example.springjdbc.service;

import org.example.springjdbc.model.Student;
import org.example.springjdbc.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(Student s) {
        studentRepository.save(s);
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
}
