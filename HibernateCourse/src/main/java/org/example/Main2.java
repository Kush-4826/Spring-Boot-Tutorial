package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Alien.class)
                .addAnnotatedClass(Laptop.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        Session session = sf.openSession();

//        Laptop l1 = session.find(Laptop.class, 4);

        // SELECT * FROM laptops WHERE ram = 32; -> SQL
        // FROM Laptop WHERE ram = 32; -> HQL

        Query<Laptop> query = session.createQuery("from Laptop WHERE ram < 32", Laptop.class);
        List<Laptop> laptops = query.getResultList();

        System.out.println(laptops);

        session.close();
        sf.close();
    }
}
