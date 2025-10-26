package com.example.app.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Alien {
    private int age;
    private ComputerSystem computerSystem;

    public int getAge() {
        return age;
    }

    @Value("21")
    public void setAge(int age) {
        this.age = age;
    }

    public ComputerSystem getComputerSystem() {
        return computerSystem;
    }


    /**
     * Adding the @Autowired annotation lets the framework know that the object of this Laptop class
     * within the Alien class will also be managed by the framework itself.
     * For the @Autowired annotation to work, we'll have to make the Laptop class a Component too!
     */
    @Autowired
    public void setComputerSystem(@Qualifier("laptop") ComputerSystem computerSystem) {
        this.computerSystem = computerSystem;
    }

    public void code() {
        System.out.println("Coding....");
        computerSystem.compile();
    }
}
