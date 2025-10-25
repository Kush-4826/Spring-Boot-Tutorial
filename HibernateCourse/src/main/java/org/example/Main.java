package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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

        Laptop laptop3 = new Laptop();
        laptop3.setId(3);
        laptop3.setBrand("Apple");
        laptop3.setModel("Macbook Pro");
        laptop3.setRam(16);

        Laptop laptop4 = new Laptop();
        laptop4.setId(4);
        laptop4.setBrand("HP");
        laptop4.setModel("Envy");
        laptop4.setRam(32);
//
//        Alien alien = new Alien();
//        alien.setaId(1);
//        alien.setaName("Kush");
//        alien.setTech("Java");
//
//        Alien alien2 = new Alien();
//        alien2.setaId(2);
//        alien2.setaName("John");
//        alien2.setTech("Python");
//
//        Alien alien3 = new Alien();
//        alien3.setaId(3);
//        alien3.setaName("Jimmy");
//        alien3.setTech("C");
//
//        alien.setLaptops(Arrays.asList(laptop, laptop2));
//        alien2.setLaptops(Arrays.asList(laptop2, laptop4));
//        alien3.setLaptops(List.of(laptop));
//
//        laptop.setAliens(Arrays.asList(alien, alien3));
//        laptop2.setAliens(Arrays.asList(alien2, alien));
//        laptop4.setAliens(List.of(alien2));

        Transaction transaction = session.beginTransaction();
//        session.merge(updatedStudent); // save or update
//        session.remove(student); // Delete

        session.persist(laptop);
        session.persist(laptop2);
        session.persist(laptop3);
        session.persist(laptop4);
//        session.persist(alien);
//        session.persist(alien2);
//        session.persist(alien3);
        transaction.commit();

        Alien a5 = session.get(Alien.class, 2);
        System.out.println(a5);
        session.close();
        sf.close();
    }
}
