package org.example;

public class Alien {
    private int age;
    private ComputerSystem computerSystem;

    public Alien() {
        System.out.println("Alien constructor called");
    }

    public Alien(int age) {
        System.out.println("Alien parameterized constructor called (1 argument)");
        this.age = age;
    }

    public Alien(int age, ComputerSystem computerSystem) {
        System.out.println("Alien parameterized constructor called (2 arguments)");
        this.age = age;
        this.computerSystem = computerSystem;
    }

    public void code() {
        System.out.println("Coding...");
        computerSystem.compile();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public ComputerSystem getComputerSystem() {
        return computerSystem;
    }

    public void setComputerSystem(ComputerSystem computerSystem) {
        this.computerSystem = computerSystem;
    }
}
