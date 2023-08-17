package com.neebal.collegemgmt.repository;

import com.neebal.collegemgmt.entities.Book;
import com.neebal.collegemgmt.repository.projections.BookTitlePrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>, BookRepositoryCustom{
    // dynamic finders
    List<Book> findBookByPrice(Double Price);

    List<Book> findBookByPriceGreaterThan(Double Price);

    List<Book> findBookByPriceGreaterThanAndPagesLessThan(Double Price, Integer pages);

    Long countBookByPagesGreaterThan(Integer Pages);

    List<Book> findBookByTitleContainingOrderByPriceDesc(String keyword);

    List<Book> findBookByTitleStartingWith(String keyword);

    boolean existsBookByTitleStartingWith(String keyword);

    List<BookTitlePrice> findBookByPagesGreaterThan(Integer pages);

    List<Book> queryBookByPriceLessThanEqual(Double price);

}

