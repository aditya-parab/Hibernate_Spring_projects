package com.neebal;

import com.neebal.entities.Book;
import com.neebal.entities.PublicationHouse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CreatePublicationHouse {

    public static void main(String[] args) {
        Book b1 = new Book("Book5",879,900.0);
        Book b2 = new Book("Book6",670,1000.0);

        PublicationHouse  publicationHouse = new PublicationHouse("adi pvt ltd",new Date());

        b1.setPublicationHouse(publicationHouse);
        b2.setPublicationHouse(publicationHouse);

        Set<Book> books  = new HashSet<>();
        books.add(b1);
        books.add(b2);

        publicationHouse.setBooks(books);

        SessionFactory sessionFactory =  HibernateUtil.getSessionFactory();

        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(publicationHouse); //no need to save the books as books has cascading on it. any change in publication house will reflect in book
            transaction.commit();
        }
        }

    }

