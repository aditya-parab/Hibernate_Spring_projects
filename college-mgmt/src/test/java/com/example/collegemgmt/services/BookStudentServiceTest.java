package com.example.collegemgmt.services;

import com.example.collegemgmt.entities.Book;
import com.example.collegemgmt.entities.Student;
import com.example.collegemgmt.exceptions.BookNotIssuedYetException;
import com.example.collegemgmt.exceptions.ResourceNotFoundException;
import com.example.collegemgmt.repository.BookRepository;
import com.example.collegemgmt.repository.BookStudentRepository;
import com.example.collegemgmt.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BookStudentServiceTest {

    @InjectMocks
    BookStudentService bookStudentService;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private BookStudentRepository bookStudentRepository;




    @Test
    void returnBookWhenBookNotFound() {
        Long bookId = 2l;
        Long studentId = 1l;

        when(this.bookRepository.findBookById(bookId)).thenReturn(null);

       NullPointerException ex =  assertThrows(
                NullPointerException.class,
                ()->this.bookStudentService.returnBook(bookId,studentId)

        );

        assertEquals(ex.getMessage(),"Book with id 2 not found");

    }

    @Test
    void returnBookWhenStudentNotFound() {
        Long bookId = 2l;
        Long studentId = 1l;

        when(bookRepository.findBookById(bookId))
                .thenReturn(new Book());

        when(this.studentRepository.findStudentById(studentId)).thenReturn(null);

        NullPointerException ex =  assertThrows(
                NullPointerException.class,
                ()->this.bookStudentService.returnBook(bookId,studentId)

        );

        assertEquals(ex.getMessage(),"Student with id 2 not found");

    }


    @Test
    void returnBookWhenBookNotIssuedToStudent() {
        Long bookId = 2l;
        Long studentId = 1l;
        Student s = new Student();
        s.setBooksIssued(new HashSet<>()); //has no books issued
        when(bookRepository.findBookById(bookId))
                .thenReturn(new Book());

        when(this.studentRepository.findStudentById(studentId)).thenReturn(s);

        BookNotIssuedYetException ex =  assertThrows(
                BookNotIssuedYetException.class,
                ()->this.bookStudentService.returnBook(bookId,studentId)

        );

        assertEquals(ex.getMessage(),String.format("Book id %s not yet issued to student %s",bookId,studentId));

    }
}