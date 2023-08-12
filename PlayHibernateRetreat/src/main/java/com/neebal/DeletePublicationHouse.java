package com.neebal;

import com.neebal.entities.Book;
import com.neebal.entities.PublicationHouse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Scanner;

public class DeletePublicationHouse {

    public static void main(String[] args) {
        long publicationHouseId;
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Enter the Publication House id: ");
            publicationHouseId = sc.nextLong();
        }

        SessionFactory sessionFactory =  HibernateUtil.getSessionFactory();

        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            PublicationHouse publicationHouse =  session.get(PublicationHouse.class, publicationHouseId);
            if(publicationHouse==null){
                System.out.println("book does not exist. failed.");
                return;
            }
            session.delete(publicationHouse);
            transaction.commit();
        }



    }
}

