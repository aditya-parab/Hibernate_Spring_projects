package com.neebal;

import com.neebal.entities.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.*;

public class QueryAuthor {

    public static void main(String[] args) {
        long authorId;

        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Enter author id");
            authorId = sc.nextLong();
        }

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try(Session session = sessionFactory.openSession()){
            Author author = session.get(Author.class,authorId);
            if(author==null){
                System.out.println("Author not found");
                return;
            }
            System.out.println("Author name: "+author.getName()+", gender: "+ author.getGender()+", country: "+author.getLocation().getCountry()+", state: "+author.getLocation().getState());
        }
    }
}
