package org.example.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "passport")
public class Passport {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @OneToOne
    @JoinColumn(name = "citizen_id", referencedColumnName = "id")
    private Citizen citizen;

    @Column(name = "passport_number")
    private int passportNumber;

    public Passport() {
    }

//    public Passport(Citizen citizen, int passportNumber) {
//        this.citizen = citizen;
//        this.passportNumber = passportNumber;
//    }

    public Passport(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }
}
