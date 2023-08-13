package com.neebal;

import com.neebal.entities.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class QueryingBooks {






    private static void findAllBooks(Session session){
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Book> cq =  cb.createQuery(Book.class);

        Root<Book> root = cq.from(Book.class);
        cq.select(root);

        List<Book> books = session
                .createQuery(cq)
                .getResultList();
        System.out.println(books);

    }

    private static void findAllBookTitles(Session session){
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<String> cq = cb.createQuery(String.class); //we want titles which are of type string
        Root<Book> root = cq.from(Book.class);

        cq.select(root.get("title"));

        List<String> titles = session
                .createQuery(cq)
                .getResultList();
        System.out.println(titles);



    }

    private static void findAllBookTitlesAndPrice(Session session){
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

        objects.forEach(object-> System.out.println(object[0]+", "+object[1]));
    }

    private static void findAllBookTitlesAndPagesGreaterThan400Desc(Session session){
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

        Root<Book> root = cq.from(Book.class);
        cq.multiselect(
                root.get("title"),
                root.get("price"),
                root.get("pages")
        )
                .where(
                        cb.greaterThan(root.get("pages"),400)
                )
                .orderBy(
                      cb.desc(root.get("price"))
                );

        List<Object[]> objects = session
                .createQuery(cq)
                .getResultList();

        objects.forEach(object-> System.out.println(object[0]+", "+object[1]+", "+object[2]));
    }
    private static void countFatBooks(Session session){
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);

        Root<Book> root = cq.from(Book.class);
        cq.select(
                        cb.count(root.get("title")) //or any column, we are just counting anyway
                )
                .where(
                        cb.greaterThan(root.get("pages"),300)
                );


        Long ans = session
                .createQuery(cq)
                .getSingleResult();

        System.out.println(ans);
    }


    public static void main(String[] args) {
        //criteria api of hibernate
        //allows for advanced querying capabilities
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try(Session session = sessionFactory.openSession()) {
            countFatBooks(session);
        }
        }

    }

