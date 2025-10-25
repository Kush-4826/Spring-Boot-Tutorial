package org.example;

public class Alien {
    private int age;
    private Laptop laptop;

    public Alien() {
        System.out.println("Alien constructor called");
    }

    public Alien(int age) {
        System.out.println("Alien parameterized constructor called (1 argument)");
        this.age = age;
    }

    public Alien(int age, Laptop laptop) {
        System.out.println("Alien parameterized constructor called (2 arguments)");
        this.age = age;
        this.laptop = laptop;
    }

    public void code() {
        System.out.println("Coding...");
        laptop.compile();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }
}
