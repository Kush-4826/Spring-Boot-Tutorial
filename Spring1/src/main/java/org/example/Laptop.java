package org.example;

public class Laptop implements ComputerSystem {
    public Laptop() {
        System.out.println("Laptop constructor called");
    }

    @Override
    public void compile() {
        System.out.println("Compiling code using Laptop...");
    }
}
