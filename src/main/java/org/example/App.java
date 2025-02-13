package org.example;

import jakarta.transaction.Transactional;
import org.example.model.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {

       // Configuration configuration = new Configuration().addAnnotatedClass(Person.class); // подключаем конфигурацию, регистрируем класс Person в hibernate
        Configuration configuration = new Configuration().addAnnotatedClass(Actor.class).addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory(); // создаем SessionFactory один раз за все приложение
        Session session = sessionFactory.getCurrentSession(); // галвный обьект для свзяи с Hibernate



        try {
            session.beginTransaction(); // начинаем транзакцию, в спринге потом если использовать @Transactional то вручную транзакциями не надо управлять


             Actor actor1 = session.get(Actor.class, 2);
            System.out.println(actor1.getMovies());

            Movie movieToRemove = actor1.getMovies().get(0);

            actor1.getMovies().remove(0);
            movieToRemove.getActors().remove(actor1);

            session.getTransaction().commit(); // применяем транзакцию

        } catch (HibernateException e) {
            e.getMessage();
        } finally {
            sessionFactory.close();
        }
    }
}
