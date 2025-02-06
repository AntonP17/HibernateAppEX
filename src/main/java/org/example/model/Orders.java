package org.example.model;

import jakarta.persistence.*;

@Entity
public class Orders {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    // многие к одному дочерняя сущность, многие заказы у одного студента
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Students student;

    public Orders(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Orders() {
    }

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
