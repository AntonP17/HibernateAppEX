package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    // многие к одному дочерняя сущность, многие заказы у одного студента
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Students student;


//    public Orders(String name, Students student) {
//        this.name = name;
//        this.student = student;
//    }

    // упрощаем конструктор
    public Orders(String orderName){
        this.name = orderName;
    }

    public Orders() {
    }

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
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


}
