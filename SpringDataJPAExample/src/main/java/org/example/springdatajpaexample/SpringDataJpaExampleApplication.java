package org.example.springdatajpaexample;

import org.example.springdatajpaexample.model.Student;
import org.example.springdatajpaexample.repo.StudentRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDataJpaExampleApplication {

    public static void main(String[] args) {
        ApplicationContext context =  SpringApplication.run(SpringDataJpaExampleApplication.class, args);

        StudentRepo studentRepo = context.getBean(StudentRepo.class);

        Student s1 = context.getBean(Student.class);
        Student s2 = context.getBean(Student.class);
        Student s3 = context.getBean(Student.class);

        s1.setRollNo(101);
        s1.setName("John");
        s1.setMarks(78);

        s2.setRollNo(102);
        s2.setName("Jimmy");
        s2.setMarks(69);

        s3.setRollNo(103);
        s3.setName("Jane");
        s3.setMarks(50);

        studentRepo.save(s1);
        studentRepo.save(s2);
        studentRepo.save(s3);
    }

}
