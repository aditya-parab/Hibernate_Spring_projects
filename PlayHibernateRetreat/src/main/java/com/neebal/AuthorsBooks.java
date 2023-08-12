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

        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            Author a1 = session.get(Author.class,1l);
            Author a2 = session.get(Author.class,2l);

            Book b3 = session.get(Book.class,3l);
            Book b4 = session.get(Book.class,4l);
            Book b5 = session.get(Book.class,5l);
            Book b6 = session.get(Book.class,6l);
            Book b7 = session.get(Book.class,7l);
            Book b8 = session.get(Book.class,8l);

            //a1 -> b3,b4,b5
            //a2 ->b4,b5,b6,b7,b8
            Set<Book> books_a1 = new HashSet<>();
            books_a1.add(b3);
            books_a1.add(b4);
            books_a1.add(b5);

            Set<Book> books_a2 = new HashSet<>();
            books_a2.add(b4);
            books_a2.add(b5);
            books_a2.add(b6);
            books_a2.add(b7);
            books_a2.add(b8);

            a1.setBooks(books_a1);
            a2.setBooks(books_a2);




            transaction.commit();
        }
    }
}
