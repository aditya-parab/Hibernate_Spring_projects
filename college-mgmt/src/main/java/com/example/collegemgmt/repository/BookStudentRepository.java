package com.example.collegemgmt.repository;

import com.example.collegemgmt.entities.Book;
import com.example.collegemgmt.entities.BookStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookStudentRepository extends JpaRepository<BookStudent, Long> {
    BookStudent findBookStudentByBook(Book book);
}
