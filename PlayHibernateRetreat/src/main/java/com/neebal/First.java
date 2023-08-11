package com.neebal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class First {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) { //creates connection to database
            System.out.println(session);

        }



    }
}