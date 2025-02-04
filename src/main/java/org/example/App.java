package org.example;

import org.example.model.Books;
import org.example.model.Person;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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

            Person person = new Person("John", 25); // создаем обьект
            Person person2 = new Person("John2", 55); // создаем обьект
            Person person3 = new Person("John3", 65); // создаем обьект
            Person person4 = new Person("Anton", 75); // создаем обьект
//
//            session.save(person); // сохраняем обьект в БД
//            session.save(person2); // сохраняем обьект в БД
//            session.save(person3); // сохраняем обьект в БД


            Person personGet = session.get(Person.class, 1);
            personGet.setName("Alex");  // обновляем обьект в БД

            Person personGet2 = session.get(Person.class, 2);
//            session.delete(personGet2); // удаляем обьект в БД

            System.out.println(person4.getId());

          Person personTest = session.get(Person.class, 1); // получаем обьект по id
            System.out.println(personTest.getName() + " " + personTest.getAge() + " "+ personTest.getId());

            session.getTransaction().commit(); // применяем транзакцию

        } catch (HibernateException e) {
            e.getMessage();
        } finally {
            sessionFactory.close();
        }
    }
}
