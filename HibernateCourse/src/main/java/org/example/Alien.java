package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "aliens")
public class Alien {
    @Id
    @Column(name = "a_id")
    private int aId;

    @Column(name = "a_name")
    private String aName;

    // does not create tech column in db
    @Transient
    private String tech;

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

    @Override
    public String toString() {
        return "Alien{" +
                "aId=" + aId +
                ", aName='" + aName + '\'' +
                ", tech='" + tech + '\'' +
                '}';
    }
}
