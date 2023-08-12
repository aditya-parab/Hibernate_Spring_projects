package com.neebal;

import com.neebal.entities.PublicationHouse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class QueryPublicationHouse {
    public static void main(String[] args) {


        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try(Session session = sessionFactory.openSession()){
            PublicationHouse publicationHouse = session.get(PublicationHouse.class,1l);
            System.out.println(String.format("Name: %s\nEstablishment date: %s",publicationHouse.getName(),publicationHouse.getEstablishmentDate()));

        }
        }
    }



