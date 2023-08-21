package com.neebal.collegemgmt.services;

import com.neebal.collegemgmt.entities.Book;
import com.neebal.collegemgmt.entities.BookStudent;
import com.neebal.collegemgmt.entities.Student;
import com.neebal.collegemgmt.exceptions.BookAlreadyIssuedException;
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


import java.util.Date;
import java.util.HashSet;
import java.util.Optional;

//import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.ExpectedCount.times;

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

        when(bookRepository.findById(bookId)).thenReturn(Optional.empty());

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

        when(bookRepository.findById(bookId))
                        .thenReturn(Optional.of(
                                new Book()
                        ));

        when(studentRepository.findById(studentId)).thenReturn(Optional.empty());

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
        when(bookRepository.findById(bookId))
                .thenReturn(Optional.of(
                        new Book()
                ));

        when(studentRepository.findById(studentId))
                .thenReturn(Optional.of(s));

        BookNotIssuedYetException ex = assertThrows(
                BookNotIssuedYetException.class,
                ()-> this.bookStudentService.returnBook(bookId,studentId)
        );
        assertEquals(ex.getMessage(),
                String.format("Book id %s has not yet issued to student %s, can not return",bookId,studentId)
        );
    }

//    @Test
//    public void testIssueBook_BookAlreadyIssued() {
//        // Mock the Book, Student, and already issued BookStudent
//        Book book = new Book();
//        book.setId(3L);
//
//        Student student = new Student();
//        student.setId(2L);
//
//        BookStudent issuedBook = new BookStudent(book, student, new Date());
//
//
//
//        // Setting up mocks to simulate a situation where the book is already issued
//        when(bookStudentRepository.findBookStudentByBookAndStudentAndReturnDateIsNull(book, student))
//                .thenReturn(issuedBook);
//
//        // Call the method, expect a BookAlreadyIssuedException to be thrown
//        assertThrows(BookAlreadyIssuedException.class, () -> {
//            bookStudentService.issueBook(3L, 2L);
//        });
//    }



}