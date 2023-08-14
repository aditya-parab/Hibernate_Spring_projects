package com.neebal;

import com.neebal.entities.Author;
import com.neebal.entities.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

public class AuthorsBooks {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try(Session session = sessionFactory.openSession()) {
            Author a1 = session.get(Author.class, 1l);
            Author a2 = session.get(Author.class, 2l);

            Book b1 = session.get(Book.class, 1l);
            Book b2 = session.get(Book.class, 2l);
            Book b3 = session.get(Book.class, 3l);
            Book b4 = session.get(Book.class, 4l);
            Book b5 = session.get(Book.class, 5l);
            Book b6 = session.get(Book.class, 6l);

            Transaction transaction = session.beginTransaction();
            // author a1 -> 2, 4, 6
            Set<Book> a1Books = new HashSet<>();
            a1Books.add(b2);
            a1Books.add(b4);
            a1Books.add(b6);
            a1.setBooks(a1Books);

            // author a2 -> 1, 2, 3, 5
            Set<Book> a2Books = new HashSet<>();
            a2Books.add(b1);
            a2Books.add(b2);
            a2Books.add(b3);
            a2Books.add(b5);
            a2.setBooks(a2Books);

            transaction.commit();
        }
    }
}
