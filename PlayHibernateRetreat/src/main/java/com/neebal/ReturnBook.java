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
        long studentId;
        long bookId;
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Enter the student id");
            studentId = sc.nextLong();
            System.out.println("Enter the book id:");
            bookId = sc.nextLong();
        }

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Student student  = session.get(Student.class,studentId);
            if(student==null){
                System.out.println("Student does not exist");
                return;
            }
            Book book = session.get(Book.class,bookId);
            if(book==null){
                System.out.println("Book does not exist");
                return;
            }

            Set<BookStudent> booksIssued = student.getBooksIssued();

            //check if book was issued before and not returned

            for(BookStudent bookstudent: booksIssued){
                if(bookstudent.getBook().equals(book) ){ //book exists as issued
                    if(bookstudent.getReturnDate()==null){ //book hasnt been returned

                        bookstudent.setReturnDate(new Date());
                        System.out.println("book has been returned");
                        session.save(bookstudent);
                        transaction.commit();
                        return;
                    }

                }
                else{
                    System.out.println("No book like this was ever issued");
                    return;
                }
            }
            System.out.println("book cannot be returned.");







        }

        }
    }
