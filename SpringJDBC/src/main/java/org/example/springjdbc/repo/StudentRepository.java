package org.example.springjdbc.repo;

import org.example.springjdbc.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    public void save(Student student) {
        System.out.println(student + " added");
    }

    public List<Student> findAll() {
        return new ArrayList<>();
    }
}
