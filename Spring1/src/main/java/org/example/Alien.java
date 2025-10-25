package org.example;

public class Alien {
    private int age;
    private Laptop laptop;

    public Alien() {
        System.out.println("Alien constructor called");
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
