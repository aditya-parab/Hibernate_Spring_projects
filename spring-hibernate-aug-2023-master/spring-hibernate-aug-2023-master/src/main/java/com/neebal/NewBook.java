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
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("enter title: ");
            title = scanner.nextLine();

            System.out.println("enter price: ");
            price = scanner.nextDouble();

            System.out.println("enter pages: ");
            pages = scanner.nextInt();
        }

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try(Session session = sessionFactory.openSession()) {
            Book book = new Book(title, pages, price);

            Transaction transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
        }
    }
}
