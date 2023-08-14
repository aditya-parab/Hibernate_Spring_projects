package com.neebal;

import com.neebal.entities.Book;
import com.neebal.entities.PublicationHouse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Set;

public class QueryPublicationHouse {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            PublicationHouse publicationHouse =
                    session.get(PublicationHouse.class, 2l);
            System.out.println(
                    String.format(
                            "Name: %s\nEstablishment date: %s",
                            publicationHouse.getName(),
                            publicationHouse.getEstablishmentDate()
                    )
            );
            Set<Book> books = publicationHouse.getBooks();
            System.out.println(books);
        }
    }
}
