package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Student student = new Student();
//        student.setName("Jimmy");
//        student.setAge(25);
//        student.setRollNo(4);

        /*********************************** INSERTING DATA **********************************/

//        Configuration cfg = new Configuration();
//        cfg.addAnnotatedClass(org.example.Student.class);
//        cfg.configure("hibernate.cfg.xml");
//
//        try(SessionFactory sessionFactory = cfg.buildSessionFactory()) {
//            Session session = sessionFactory.openSession();
//
//            Transaction transaction = session.beginTransaction();
//            session.persist(student);
//            transaction.commit();
//        }

        // OR

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Alien.class)
                .addAnnotatedClass(Laptop.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        Session session = sf.openSession();
//        Transaction transaction = session.beginTransaction();

//        session.persist(student);

//        transaction.commit();


//        System.out.println(student);

        /*********************************** INSERTING DATA **********************************/

//        student = session.find(org.example.Student.class, 1);
//
//        System.out.println(student);

//        Student updatedStudent = new Student();
//        updatedStudent.setName("Jimmy");
//        updatedStudent.setAge(30);
//        updatedStudent.setRollNo(4);

        Laptop laptop = new Laptop();
        laptop.setId(1);
        laptop.setBrand("Lenovo");
        laptop.setModel("Ideapad");
        laptop.setRam(16);

        Laptop laptop2 = new Laptop();
        laptop2.setId(2);
        laptop2.setBrand("Dell");
        laptop2.setModel("XPS");
        laptop2.setRam(16);

        Alien alien = new Alien();
        alien.setaId(1);
        alien.setaName("Kush");
        alien.setLaptops(Arrays.asList(laptop, laptop2));
        alien.setTech("Java");

        laptop.setAlien(alien);
        laptop2.setAlien(alien);

        Transaction transaction = session.beginTransaction();
//        session.merge(updatedStudent); // save or update
//        session.remove(student); // Delete

        session.persist(laptop);
        session.persist(laptop2);
        session.persist(alien);
        transaction.commit();

        session.close();
        sf.close();
    }
}
