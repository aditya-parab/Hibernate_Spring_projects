package com.neebal;

import com.neebal.entities.Person;
import com.neebal.entities.Professor;
import com.neebal.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CreateStudent {

    public static void main(String[] args) {
        /* Student student = new Student(
                "rahul",
                'm',
                78
        ); */
        /* Professor professor = new Professor(
                "jane",
                'f',
                "BE"
        ); */
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            /* Transaction transaction = session.beginTransaction();
            session.save(professor);
            transaction.commit(); */
            List<Person> persons = session
                    .createQuery(
                            "from Person s",
                            Person.class
                    ).getResultList();
        }
    }
}
