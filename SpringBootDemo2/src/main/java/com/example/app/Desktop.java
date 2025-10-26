package com.example.app;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Desktop implements ComputerSystem {
    @Override
    public void compile() {
        System.out.println("Desktop compile");
    }
}
