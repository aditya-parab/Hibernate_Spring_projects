package com.example.collegemgmt.repository;

import com.example.collegemgmt.entities.Book;
import com.example.collegemgmt.entities.BookStudent;
import com.example.collegemgmt.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookStudentRepository extends JpaRepository<BookStudent, Long> {
    BookStudent findBookStudentByBook(Book book);
    BookStudent findBookStudentByBookAndStudent(Book book, Student student);
    BookStudent findBookStudentByBookAndStudentAndReturnDateIsNull(Book book, Student student);

}
