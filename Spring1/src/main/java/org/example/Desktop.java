package org.example;

public class Desktop implements ComputerSystem {
    public Desktop() {
        System.out.println("Desktop constructor called");
    }

    @Override
    public void compile() {
        System.out.println("Compiling code using Desktop...");
    }
}
