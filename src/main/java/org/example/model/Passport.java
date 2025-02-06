package org.example.model;

import jakarta.persistence.*;

@Entity
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "number")
    private String number;

    @OneToOne(mappedBy = "passport")
    private  Сitizen citizen;

    public Passport( String number) {

        this.number = number;
    }

    public Passport() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Сitizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Сitizen citizen) {
        this.citizen = citizen;
    }
}
