package com.neebal;

import com.neebal.entities.BookStudent;
import com.neebal.entities.Student;
import com.neebal.entities.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.Scanner;
import java.util.Set;

public class IssueBook {

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

        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            BookStudent bookStudent = new BookStudent();


            Student student = session.get(Student.class,studentId);
            if(student==null){
                System.out.println("Student does not exist");
                return;
            }

            Book book = session.get(Book.class,bookId);
            if(book==null){
                System.out.println("Book does not exist");
                return;
            }



            //check if book is currently already issued by Student
            Set<BookStudent> booksIssued = student.getBooksIssued();


            //easy way

//            for(BookStudent bookstudent: booksIssued){
//                if(bookstudent.getBook().equals(book) && bookstudent.getReturnDate()==null){
//                    System.out.println("The book is already been issued by Student");
//                    return;
//                }
//            }

            //stream
            long count = booksIssued
                    .stream()
                            .filter(bookstudent->bookstudent.getBook().equals(book) && bookstudent.getReturnDate()==null)
                                    .count();
            if(count>0){
                System.out.println("The book is already been issued by Student");
                return;
            }




            bookStudent.setStudent(student);
            bookStudent.setBook(book);
            bookStudent.setIssuedDate(new Date());

            System.out.println(bookStudent);

            session.save(bookStudent); //Because bookStudent is not managed entity here
            transaction.commit();

        }
    }

}
