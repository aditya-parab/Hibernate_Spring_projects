package com.neebal;

import com.neebal.entities.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Scanner;

public class UpdateBook {

    public static void main(String[] args) {
        long bookId;
        int pages;

        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Enter the book id: ");
            bookId = sc.nextLong();

            System.out.println("Enter the NEW pages to be changed to: ");
            pages = sc.nextInt();
        }

        SessionFactory sessionFactory =  HibernateUtil.getSessionFactory();

        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            Book book = session.get(Book.class,bookId);
            if(book==null){
                System.out.println("Book does not exist..");
                return;
            }
            book.setPages(pages);
            transaction.commit();

        }
    }
}
