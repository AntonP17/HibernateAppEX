package org.example;

import jakarta.transaction.Transactional;
import org.example.model.Books;
import org.example.model.Orders;
import org.example.model.Person;
import org.example.model.Students;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {

       // Configuration configuration = new Configuration().addAnnotatedClass(Person.class); // подключаем конфигурацию, регистрируем класс Person в hibernate
        Configuration configuration = new Configuration().addAnnotatedClass(Students.class).addAnnotatedClass(Orders.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory(); // создаем SessionFactory один раз за все приложение
        Session session = sessionFactory.getCurrentSession(); // галвный обьект для свзяи с Hibernate



        try {
            session.beginTransaction(); // начинаем транзакцию, в спринге потом если использовать @Transactional то вручную транзакциями не надо управлять

            Students students = new Students("Ivan", 23);

            students.addOrder(new Orders("order1"));
            students.addOrder(new Orders("order2"));
            students.addOrder(new Orders("order3"));

            // старый код
//            Students students = new Students("Ivan", 23);
//            students.addOrder(new Orders("order1"));
//            students.addOrder(new Orders("order2"));
//            students.addOrder(new Orders("order3"));

            session.save(students);

            session.getTransaction().commit(); // применяем транзакцию

        } catch (HibernateException e) {
            e.getMessage();
        } finally {
            sessionFactory.close();
        }
    }
}
