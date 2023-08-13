package com.neebal;

import com.neebal.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Scanner;

public class CreateStudent {

    public static void main(String[] args) {
//        Student student = new Student("DDD",'f',4);
        String name;
        char gender;
        int roll;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter student name: ");
            name = scanner.nextLine();
            System.out.println("Enter student gender: ");
            gender = scanner.nextLine().charAt(0);

            System.out.println("Enter student roll no: ");
            roll = scanner.nextInt();
        }
        Student student = new Student(name,gender,roll);

        SessionFactory sessionFactory =  HibernateUtil.getSessionFactory();

        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        }
    }
}
