package com.example.app.service;

import com.example.app.model.Laptop;
import com.example.app.repo.LaptopRepository;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {

    private final com.example.app.repo.LaptopRepository laptopRepository;

    public LaptopService(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    public void addLaptop(Laptop laptop) {
        System.out.println("addLaptop called");
        laptopRepository.save(laptop);
    }
}
