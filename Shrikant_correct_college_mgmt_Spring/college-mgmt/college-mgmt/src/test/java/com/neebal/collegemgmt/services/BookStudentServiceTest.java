package com.neebal.collegemgmt.services;

import com.neebal.collegemgmt.entities.Book;
import com.neebal.collegemgmt.entities.Student;
import com.neebal.collegemgmt.exceptions.BookNotIssuedYetException;
import com.neebal.collegemgmt.exceptions.ResourceNotFoundException;
import com.neebal.collegemgmt.repository.BookRepository;
import com.neebal.collegemgmt.repository.BookStudentRepository;
import com.neebal.collegemgmt.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BookStudentServiceTest {

    @InjectMocks
    private BookStudentService bookStudentService;

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

        Mockito.when(bookRepository.findById(bookId)).thenReturn(Optional.empty());

        ResourceNotFoundException ex = assertThrows(
                ResourceNotFoundException.class,
                ()-> this.bookStudentService.returnBook(bookId,studentId)
        );


        assertEquals(ex.getMessage(), "Book with id "+bookId+" not found");
    }
    @Test
    void returnBookWhenStudentNotFound() {
        Long bookId = 2l;
        Long studentId = 10l;

        Mockito.when(bookRepository.findById(bookId))
                        .thenReturn(Optional.of(
                                new Book()
                        ));

        Mockito.when(studentRepository.findById(studentId)).thenReturn(Optional.empty());

        ResourceNotFoundException ex = assertThrows(
                ResourceNotFoundException.class,
                ()-> this.bookStudentService.returnBook(bookId,studentId)
        );


        assertEquals(ex.getMessage(), "Student with id "+studentId+" not found");
    }

    @Test
    void returnBookWhenBookNotIssuedToStudent(){
        Long bookId = 2l;
        Long studentId = 1l;

        Student s = new Student();
        s.setBooksIssued(new HashSet<>());
        Mockito.when(bookRepository.findById(bookId))
                .thenReturn(Optional.of(
                        new Book()
                ));

        Mockito.when(studentRepository.findById(studentId))
                .thenReturn(Optional.of(s));

        BookNotIssuedYetException ex = assertThrows(
                BookNotIssuedYetException.class,
                ()-> this.bookStudentService.returnBook(bookId,studentId)
        );
        assertEquals(ex.getMessage(),
                String.format("Book id %s has not yet issued to student %s, can not return",bookId,studentId)
        );
    }
}