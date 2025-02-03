package org.example.model;

import jakarta.persistence.*;

@Entity
public class Books {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "books_seq", sequenceName = "books_seq", allocationSize = 1) // как генерируется sequence
    private int id;

    @Column(name = "tittle")
    private String tittle;

    @Column(name = "year")
    private int year;

    public Books(int id, String tittle, int year) {
        this.id = id;
        this.tittle = tittle;
        this.year = year;
    }

    public Books() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
