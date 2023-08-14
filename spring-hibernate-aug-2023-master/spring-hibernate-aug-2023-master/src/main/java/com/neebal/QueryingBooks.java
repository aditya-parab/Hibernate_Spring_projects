package com.neebal;

import com.neebal.entities.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class QueryingBooks {

    private static void findAllBooks(Session session) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Book> cq =  cb.createQuery(Book.class);

        Root<Book> root = cq.from(Book.class);
        cq.select(root);

        List<Book> books = session
                .createQuery(cq)
                .getResultList();
        System.out.println(books);
    }

    private static void findAllBookTitles(Session session) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<String> cq = cb.createQuery(String.class);

        Root<Book> root = cq.from(Book.class);
        cq.select(root.get("title"));

        List<String> titles = session
                .createQuery(cq)
                .getResultList();
        System.out.println(titles);
    }

    private static void findAllBookTitlesAndPrice(Session session) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

        Root<Book> root = cq.from(Book.class);
        cq.multiselect(
                root.get("title"),
                root.get("price")
        );

        List<Object[]> objects = session
                .createQuery(cq)
                .getResultList();
        objects.forEach(object -> System.out.println(object[0] + " " + object[1]));
    }

    private static void findAllBookTitlesAndPriceByPages(Session session) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

        Root<Book> root = cq.from(Book.class);
        cq
                .multiselect(
                    root.get("title"),
                    root.get("price")
                )
                .where(
                    cb.greaterThan(root.get("pages"), 500)
                )
                .orderBy(
                        cb.desc(root.get("price"))
                );

        List<Object[]> objects = session
                .createQuery(cq)
                .getResultList();
        objects.forEach(object -> System.out.println(object[0] + " " + object[1]));
    }

    private static void countBooksByPages(Session session) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);

        Root<Book> root = cq.from(Book.class);
        cq
                .select(
                        cb.count(root.get("title"))
                )
                .where(
                        cb.greaterThan(root.get("pages"), 500)
                );

        Long count = session
                .createQuery(cq)
                .getSingleResult();
        System.out.println(count);
    }

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try(Session session = sessionFactory.openSession()) {
            // criteria api of hibernate
            // advanced querying capabilities
            // findAllBooks(session);
            // findAllBookTitles(session);
            // findAllBookTitlesAndPrice(session);
            // findAllBookTitlesAndPriceByPages(session);
            countBooksByPages(session);
        }
    }
}
