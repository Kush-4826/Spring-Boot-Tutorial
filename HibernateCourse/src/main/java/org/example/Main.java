package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Jimmy");
        student.setAge(25);
        student.setRollNo(4);

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
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        Session session = sf.openSession();
//        Transaction transaction = session.beginTransaction();

//        session.persist(student);

//        transaction.commit();


//        System.out.println(student);

        /*********************************** INSERTING DATA **********************************/

        student = session.find(org.example.Student.class, 1);

        System.out.println(student);

        Student updatedStudent = new Student();
        updatedStudent.setName("Jimmy");
        updatedStudent.setAge(30);
        updatedStudent.setRollNo(4);

        Transaction transaction = session.beginTransaction();
        session.merge(updatedStudent); // save or update
//        session.remove(student); // Delete
        transaction.commit();

        session.close();
        sf.close();
    }
}
