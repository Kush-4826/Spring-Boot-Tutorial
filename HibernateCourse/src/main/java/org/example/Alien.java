package org.example;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "aliens")
public class Alien {
    @Id
    @Column(name = "a_id")
    private int aId;

    @Column(name = "a_name")
    private String aName;

    private String tech;

    @OneToMany(mappedBy = "alien")
    private List<Laptop> laptops;

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aId=" + aId +
                ", aName='" + aName + '\'' +
                ", tech='" + tech + '\'' +
                ", laptop=" + laptops +
                '}';
    }
}
