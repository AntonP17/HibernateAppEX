package org.example.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "citizen")
public class Citizen {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "citizen")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    // cascade = CascadeType.ALL
    private Passport passport;

    public Citizen(String name) {
        this.name = name;
    }

    public Citizen() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Passport getPassport() {
        return passport;
    }

//    public void setPassport(Passport passport) {
//        this.passport = passport;
//    }

    public void setPassport(Passport passport) {
        this.passport = passport;
        passport.setCitizen(this);
    }
}
