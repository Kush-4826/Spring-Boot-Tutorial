package com.example.app;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements ComputerSystem {
    @Override
    public void compile() {
        System.out.println("Laptop compile");
    }
}
