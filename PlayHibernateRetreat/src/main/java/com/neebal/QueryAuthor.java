package com.neebal;

import com.neebal.entities.Author;
import com.neebal.entities.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.*;

public class QueryAuthor {

    public static void main(String[] args) {
        long authorId1;


        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Enter author 1 id");
            authorId1 = sc.nextLong();

        }



        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try(Session session = sessionFactory.openSession()){
            Author a1 = session.get(Author.class,authorId1);

            if(a1==null){
                System.out.println("Author not found");
                return;
            }
            System.out.println("Author name: "+a1.getName()+", gender: "+ a1.getGender()+", country: "+a1.getLocation().getCountry()+", state: "+a1.getLocation().getState());
            System.out.println("A1 Authors books: ");
//            for(Book book: a1.getBooks()){
//                System.out.println(book.getTitle());
//            }

            a1
                    .getBooks()
                    .forEach(book -> System.out.println(book.getTitle()));


        }
    }
}
