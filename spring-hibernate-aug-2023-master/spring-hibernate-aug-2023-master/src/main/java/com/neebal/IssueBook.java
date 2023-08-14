package com.neebal;

import com.neebal.entities.Book;
import com.neebal.entities.BookStudent;
import com.neebal.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.Scanner;
import java.util.Set;

public class IssueBook {

    public static void main(String[] args) {
        long bookId;
        long studentId;

        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("enter book id: ");
            bookId = scanner.nextLong();

            System.out.println("enter student id: ");
            studentId = scanner.nextLong();
        }

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try(Session session = sessionFactory.openSession()) {
            Book book = session.get(Book.class, bookId);
            Student student = session.get(Student.class, studentId);

            // check
            Set<BookStudent> booksIssued = student.getBooksIssued();
            long count = booksIssued
                    .stream()
                    .filter(bookStudent ->
                                bookStudent.getBook() == book
                                        && bookStudent.getReturnDate() == null)
                    .count();
            if (count > 0) {
                System.out.println("book already issued. cannot reissue");
                return;
            }

            BookStudent bs = new BookStudent(
                    book,
                    student,
                    new Date()
            );
            Transaction transaction = session.beginTransaction();
            session.save(bs);
            transaction.commit();
        }
    }
}
