package com.neebal;

import com.neebal.entities.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Scanner;

public class DeleteBook {

    public static void main(String[] args) {
        long bookId;
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Enter the book id: ");
            bookId = sc.nextLong();
        }

        SessionFactory sessionFactory =  HibernateUtil.getSessionFactory();

        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            Book book =  session.get(Book.class, bookId);
            if(book==null){
                System.out.println("book does not exist. failed.");
                return;
            }
            session.delete(book);
            transaction.commit();
    }



    }
}

