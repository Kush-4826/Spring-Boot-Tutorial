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

        String brand = "Lenovo";

        Query<String[]> query = session.createQuery("select brand, model from Laptop WHERE brand like ?1", String[].class);
        query.setParameter(1, brand);
        List<String[]> laptops = query.getResultList();

        for(String[] laptop : laptops){
            System.out.println(laptop[0] +  " " + laptop[1]);
        }

//        System.out.println(laptops);

        session.close();
        sf.close();
    }
}
