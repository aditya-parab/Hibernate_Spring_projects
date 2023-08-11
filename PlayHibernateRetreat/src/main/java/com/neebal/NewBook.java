package com.neebal;

import com.neebal.entities.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Scanner;

public class NewBook {

    public static void main(String[] args) {

        String title;
        double price;
        int pages;

    try(Scanner sc  = new Scanner(System.in)){
        System.out.println("Enter the title: ");
        title = sc.nextLine();

        System.out.println("Enter the price: ");
         price = sc.nextDouble();

        System.out.println("Enter the pages: ");
         pages = sc.nextInt();
    }

//        System.out.println("title: "+ title+", price: "+price+", pages: "+pages);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try(Session session = sessionFactory.openSession()){
            Book book = new Book(title,pages,price);
            Transaction transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
        }


    }
}
