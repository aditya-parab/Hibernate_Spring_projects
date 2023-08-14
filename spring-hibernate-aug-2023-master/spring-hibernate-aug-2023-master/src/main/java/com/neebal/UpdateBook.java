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

        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("enter book id: ");
            bookId = scanner.nextLong();

            System.out.println("enter new pages: ");
            pages = scanner.nextInt();
        }

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try(Session session = sessionFactory.openSession()) {
            Book book = session.get(Book.class, bookId);
            if (book != null) {
                Transaction transaction = session.beginTransaction();
                book.setPages(pages);
                transaction.commit();
            } else {
                System.out.println("no book found to update");
            }
        }
    }
}
