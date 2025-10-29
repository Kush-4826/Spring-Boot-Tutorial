package org.example.springdatajpaexample.repo;

import org.example.springdatajpaexample.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {

//    @Query("select s from Student s where s.name = ?1")
    Student findStudentByName(String name);


    // This method works automatically because of query DSL
    // TODO: Write docs
    List<Student> findStudentByMarksLessThan(int marksIsLessThan);
}
