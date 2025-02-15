package org.example.model;

//import com.sun.org.apache.xpath.internal.operations.Or;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
//import sun.jvm.hotspot.ui.SAEditorPane;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
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
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "student")
           // cascade = CascadeType.PERSIST,
         //   fetch = FetchType.LAZY // вот эта строка интересная это и есть ленивая загрузка,чтобы каждый раз не обращаться дофига раз к БД
    // мы можем загрузить только пользователя , а заказы только потом при нужности
    private List<Orders> orders;


    // Многие ко многим: студент может записаться на несколько курсов
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "student_course", // Название промежуточной таблицы
//            joinColumns = @JoinColumn(name = "student_id"), // Столбец для Student
//            inverseJoinColumns = @JoinColumn(name = "course_id") // Столбец для Course сущность на другой стороне связи
//    )
//    private Set<Course> courses;

    public Students(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Students() {

    }
    // для упрощения создадим отдельный метод для добавление товара человеку и человека  товару
    public void addOrder (Orders orders){
        if (this.orders == null){
            this.orders = new ArrayList<>();
        }

        this.orders.add(orders);
        orders.setStudent(this);
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
