package com.neebal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.neebal.entities.Book;

import java.util.Scanner;

public class SearchBook {

    public static void main(String[] args) {
        long bookId;

        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Enter the book id: ");
            bookId = sc.nextLong();
        }

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try(Session session = sessionFactory.openSession()){
           Book book =  session.get(Book.class, bookId);
           if(book!=null){
               System.out.println(book);
           }
           else{
               System.out.println("Book is not found");
           }
        }
    }

}
