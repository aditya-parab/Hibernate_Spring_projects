package com.neebal;

import com.neebal.entities.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.*;




//Hibernate Query Language
public class QueryingBooksHql {

    private static void findAllBooks(Session session) {
        String query = "Select b from Book b";

        List<Book> books = session.createQuery(
                query, Book.class
        ).getResultList();
        System.out.println(books);

    }

    private static void findAllBookTitles(Session session) {


        List<String> titles = session
                .createNamedQuery(
                        "Book.FindAllBookTitles", String.class
                )
                .getResultList();

        System.out.println(titles);
    }

    private static void findAllBookTitlesAndPrice(Session session) {
//        String query = "Select b.title,b.price from Book b";

        List<Object[]> rows = session
                .createNamedQuery(
                        "Book.findTitlePrice", Object[].class
                )
                .getResultList();

        for(Object[] row : rows){
            System.out.println(row[0]+" , "+row[1]);
        }

    }

    private static void findAllBookTitlesAndPagesGreaterThan400Desc(Session session,int pages){
       List<Object[]> rows =  session
                .createNamedQuery("Book.findAllBookTitlesAndPagesGreaterThan400Desc",Object[].class)
               .setParameter("pages",pages)
               .getResultList();

       for(Object[] row : rows){
           System.out.println(row[0]+" , "+row[1]);
       }
    }

    private static void countFatBooks(Session session,int pages){
        String query = "select count(b.title) from Book b where b.pages> :pages";

        long count = session.createQuery(query, Long.class)
                .setParameter("pages",pages)
                .getSingleResult();

        System.out.println(count);

    }

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
//            findAllBooks(session);
//            findAllBookTitles(session);
//            findAllBookTitlesAndPrice(session);

            findAllBookTitlesAndPagesGreaterThan400Desc(session,400);

//            countFatBooks(session, 400);

        }
    }
}
