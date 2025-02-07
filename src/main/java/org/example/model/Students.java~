package org.example.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Students {

    @Id
    @Column(name = "id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    // один ко многим, родительская сущность , один студент может иметь много заказов
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Orders> orders;


    // Многие ко многим: студент может записаться на несколько курсов
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "student_course", // Название промежуточной таблицы
//            joinColumns = @JoinColumn(name = "student_id"), // Столбец для Student
//            inverseJoinColumns = @JoinColumn(name = "course_id") // Столбец для Course
//    )
//    private Set<Course> courses;

    public Students(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Students() {

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
}
