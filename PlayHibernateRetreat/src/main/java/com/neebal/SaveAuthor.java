package com.neebal;

import com.neebal.entities.Author;
import com.neebal.entities.Book;
import com.neebal.entities.Location;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Column;
import java.util.Scanner;

public class SaveAuthor {
    public static void main(String[] args) {
         long authorId;

         String name;

         int ratings;

        char gender;

        String country;

        String state;

        int pincode;

        try(Scanner sc = new Scanner(System.in)){


            System.out.println("Enter the name of Author: ");
            name = sc.nextLine();

            System.out.println("Enter the ratings:");
            ratings = sc.nextInt();

            System.out.println("Enter the gender: ");
            gender= sc.next().charAt(0);

            System.out.println("Enter the locations country");
            country = sc.next();

            System.out.println("Enter the locations state");
            state = sc.next();

            System.out.println("Enter the locations pincode");
            pincode = sc.nextInt();
        }



        SessionFactory sessionFactory =  HibernateUtil.getSessionFactory();

        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Location location = new Location(country,state,pincode);


            Author author = new Author(name,ratings,gender,location);
//            author.setLocation(location);
            session.save(author);
//            session.save(location); // no need to save location as the location in author is cascaded
            transaction.commit();


        }
        }
    }

