package com.neebal;

import com.neebal.entities.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class QueryAuthor {
    public static void main(String[] args) {
        long authorId;
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("enter author id: ");
            authorId = scanner.nextLong();
        }

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Author author = session.get(Author.class, authorId);
            if (author != null) {
                System.out.println(
                        String.format(
                                "Name: %s\nGender: %s\nCountry: %s\nState: %s",
                                author.getName(),
                                author.getGender(),
                                author.getLocation().getCountry(),
                                author.getLocation().getState()));
                author
                        .getBooks()
                        .forEach(book -> System.out.println(book.getTitle()));
            } else {
                System.out.println("Author not found");
            }
        }
    }
}
