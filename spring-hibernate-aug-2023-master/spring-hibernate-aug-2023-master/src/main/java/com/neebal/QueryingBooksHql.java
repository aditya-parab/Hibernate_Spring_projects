package com.neebal;

import com.neebal.entities.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

// Hibernate Query Language (HQL)
public class QueryingBooksHql {

    private static void findAllBooks(Session session) {
        List<Book> books = session
                .createQuery(
                        "from Book b",
                        Book.class
                )
                .getResultList();
        System.out.println(books);
    }

    private static void findAllBookTitles(Session session) {
       List<String> titles = session
               .createQuery(
                       "select b.title from Book b",
                       String.class
               ).getResultList();
        System.out.println(titles);
    }

    private static void findAllBookTitlesAndPrice(Session session) {
        /* List<Object[]> rows = session
                .createQuery(
                        "select b.title, b.price from Book b",
                        Object[].class
                ).getResultList();
        rows.forEach(row -> System.out.println(row[0] + " " + row[1])); */
        List<Object[]> rows = session
                .createNamedQuery("Book.findTitlePrice", Object[].class)
                .getResultList();
        rows.forEach(row -> System.out.println(row[0] + " " + row[1]));
    }

    private static void findAllBookTitlesAndPriceByPages(Session session, int pages) {
        /* List<Object[]> rows = session
                .createQuery(
                        "select b.title, b.price " +
                                "from Book b " +
                                "where b.pages > :pages " +
                                "order by b.price desc",
                        Object[].class
                )
                .setParameter("pages", pages)
                .getResultList(); */
        List<Object[]> rows = session
                .createNamedQuery(
                        "Book.findTitlePriceByPagesOrderByPrice",
                        Object[].class
                )
                .setParameter("pages", pages)
                .getResultList();
        rows.forEach(row -> System.out.println(row[0] + " " + row[1]));
    }

    private static void countBooksByPages(Session session, int pages) {
        Long count = session
                .createQuery(
                        "select count(b.title) " +
                                "from Book b " +
                                "where b.pages > :pages",
                        Long.class
                )
                .setParameter("pages", pages)
                .getSingleResult();
        System.out.println(count);
    }

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            // findAllBooks(session);
            // findAllBookTitles(session);
            // findAllBookTitlesAndPrice(session);
            findAllBookTitlesAndPriceByPages(session, 500);
            // countBooksByPages(session, 500);
        }
    }
}
