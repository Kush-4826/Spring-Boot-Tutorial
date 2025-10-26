package com.example.app.service;

import com.example.app.model.Laptop;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {
    public void addLaptop(Laptop laptop) {
        System.out.println("addLaptop called");
    }
}
