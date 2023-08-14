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

public class ReturnBook {

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

            Set<BookStudent> booksIssued = student.getBooksIssued();
            for(BookStudent bookStudent: booksIssued) {
                if (bookStudent.getBook() == book && bookStudent.getReturnDate() == null) {
                    Transaction transaction = session.beginTransaction();
                    bookStudent.setReturnDate(new Date());
                    transaction.commit();
                    System.out.println("Book returned successfully");
                    return;
                }
            }

            System.out.println("Book not yet issued");
        }
    }
}
