package org.example;

import org.example.model.Books;
import org.example.model.Person;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {

        Configuration configuration = new Configuration().addAnnotatedClass(Person.class); // подключаем конфигурацию, регистрируем класс Person в hibernate

        SessionFactory sessionFactory = configuration.buildSessionFactory(); // создаем SessionFactory один раз за все приложение
        Session session = sessionFactory.getCurrentSession(); // галвный обьект для свзяи с Hibernate

        try {
            session.beginTransaction(); // начинаем транзакцию

            // HQL запрос
          //  List<Person> people = session.createQuery("FROM Person").getResultList(); всех получаем

            List<Person> people = session.createQuery("FROM Person WHERE name LIKE 'A%' ").getResultList(); // получаем по условию

           // session.createQuery("UPDATE Person SET name = 'Alex' where age < 30").executeUpdate(); // обновляем по условию

            session.createQuery("DELETE FROM Person WHERE age < 30").executeUpdate(); // удаляем по условию


            for (Person person : people) {
                System.out.println(person.getName() + " " + person.getAge() + " "+ person.getId());
            }

            session.getTransaction().commit(); // применяем транзакцию

        } catch (HibernateException e) {
            e.getMessage();
        } finally {
            sessionFactory.close();
        }
    }
}
