package org.example.springjdbc;

import org.example.springjdbc.model.Student;
import org.example.springjdbc.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);

        StudentService studentService = context.getBean(StudentService.class);

        Student s = context.getBean(Student.class);
        s.setRollNo(4);
        s.setName("Kush");
        s.setMarks(100);

        studentService.addStudent(s);
        List<Student> students = studentService.getStudents();
        System.out.println(students);
    }

}
