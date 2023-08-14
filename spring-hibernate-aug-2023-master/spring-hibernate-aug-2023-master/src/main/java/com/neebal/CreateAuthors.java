package com.neebal;

import com.neebal.entities.Author;
import com.neebal.entities.Location;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CreateAuthors {

    public static void main(String[] args) {
        Location location = new Location("USA", "MI", 34563);
        Author author = new Author("jane", 4, 'f', location);

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(author);
            transaction.commit();
        }
    }
}
