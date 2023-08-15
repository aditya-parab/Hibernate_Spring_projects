package com.example.collegemgmt.repository;

import com.example.collegemgmt.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {

    //dynamic finders
    List<Book> findBookByPrice(double price);
    List<Book> findBookByPriceGreaterThan(double price);
    List<Book> findBookByPriceGreaterThanAndPagesLessThan(double price,int pages);
    int countBookByPagesGreaterThan(int pages);
    List<Book> findBookByTitleContainingOrderByPriceDesc(String keyword);


}
