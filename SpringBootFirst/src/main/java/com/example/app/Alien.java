package com.example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Alien {
    /**
     * Adding the @Autowired annotation lets the framework know that the object of this Laptop class
     * within the Alien class will also be managed by the framework itself.
     * For the @Autowired annotation to work, we'll have to make the Laptop class a Component too!
     */
    @Autowired
    Laptop laptop;

    public void code() {
        System.out.println("Coding....");
        laptop.compile();
    }
}
