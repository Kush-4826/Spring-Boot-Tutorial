package com.example.app.repo;

import com.example.app.model.Laptop;
import org.springframework.stereotype.Repository;

@Repository
public class LaptopRepository {

    public void save(Laptop laptop) {
        // TODO: Save laptop to database.
        System.out.println("Laptop Saved in Database");
    }
}
