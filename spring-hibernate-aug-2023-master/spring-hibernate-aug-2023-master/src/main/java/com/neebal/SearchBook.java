package com.neebal;

import com.neebal.entities.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class SearchBook {

    public static void main(String[] args) {
        long bookId;
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("enter book id: ");
            bookId = scanner.nextLong();
        }

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try(Session session = sessionFactory.openSession()) {
            Book book = session.get(Book.class, bookId);
            if (book != null) {
                System.out.println(book);
            } else {
                System.out.println("book not found");
            }
        }
    }
}
