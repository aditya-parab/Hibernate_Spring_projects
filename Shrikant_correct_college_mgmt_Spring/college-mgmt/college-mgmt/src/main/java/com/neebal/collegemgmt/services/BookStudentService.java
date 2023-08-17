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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

@Service
public class BookStudentService {

    private BookRepository bookRepository;

    private StudentRepository studentRepository;

    private BookStudentRepository bookStudentRepository;

    public BookStudentService(){};

    public BookStudentService(
            BookRepository bookRepository,
            StudentRepository studentRepository,
            BookStudentRepository bookStudentRepository
    ){
        this.bookRepository = bookRepository;
        this.studentRepository = studentRepository;
        this.bookStudentRepository = bookStudentRepository;
    };


    @Autowired
    @Lazy
    private BookStudentService bookStudentService;

    @Autowired
    private SendEmailService sendEmailService;

    @Transactional
    public BookStudent issueBook(Long bookId, Long studentId){

        /*Optional<Book> o1 = bookRepository.findById(bookId);
        if(o1.isEmpty()){
            //exception
            throw new ResourceNotFoundException(
                    String.format("Book with id %s not found",bookId)
            );
        }
        Optional<Student> o2 = studentRepository.findById(studentId);
        if(o2.isEmpty()){
            //exception
            throw new ResourceNotFoundException(
                    String.format("Student with id %s not found",studentId)
            );
        }
        Book book = o1.get();
        Student student = o2.get();*/

        Book book = bookRepository.findById(bookId)
                .orElseThrow(()->new ResourceNotFoundException(
                        String.format("Book with id %s not found",bookId)
                ));
        Student student = studentRepository.findById(studentId)
                .orElseThrow(()->new ResourceNotFoundException(
                        String.format("Student with id %s not found",studentId)
                ));

        Set<BookStudent> booksIssued = student.getBooksIssued();

        long count = booksIssued.stream().filter(bookIssue ->
                        bookIssue.getBook() == book && bookIssue.getReturnDate() == null)
                .count();

        if (count > 0) {
            throw new BookAlreadyIssuedException(
                    String.format("Book %s has already been issued to student %s, can not reissue",book.getTitle(),student.getUsername())
            );
        }

        BookStudent bookStudent = new BookStudent(book, student, new Date());
        this.bookStudentRepository.save(bookStudent);




        return bookStudent;
    }
    @Transactional
    public BookStudent returnBook(Long bookId, Long studentId){
        Book book = bookRepository.findById(bookId)
                .orElseThrow(()->new ResourceNotFoundException(
                        String.format("Book with id %s not found",bookId)
                ));
        Student student = studentRepository.findById(studentId)
                .orElseThrow(()->new ResourceNotFoundException(
                        String.format("Student with id %s not found",studentId)
                ));

        Set<BookStudent> booksIssued = student.getBooksIssued();

//        for (BookStudent bookIssue : booksIssued) {
//            if (bookIssue.getBook() == book && bookIssue.getReturnDate() == null) {
//                bookIssue.setReturnDate(new Date());
//                bookStudentRepository.save(bookIssue);
//                System.out.println("The book returned successfully!");
//                return bookIssue;
//            }
//        }
        //throw new BookNotIssuedYetException("The book hasn't been issued yet");

        long count = booksIssued.stream().filter(bookIssue ->
                        bookIssue.getBook() == book && bookIssue.getReturnDate() == null)
                .count();

        if (count == 0) {
            throw new BookNotIssuedYetException(
                    String.format("Book id %s has not yet issued to student %s, can not return",bookId,studentId)
            );
        }
        BookStudent bookStudent = bookStudentRepository
                .findBookStudentByBookAndStudentAndReturnDateIsNull(
                        book,
                        student
                );
        bookStudent.setReturnDate(new Date());
        this.bookStudentRepository.save(bookStudent);
        return bookStudent;

    }


    @Transactional
    public void transferBook(Long bookId, Long fromStudentId, Long toStudentId){

        bookStudentService.returnBook(bookId, fromStudentId);

        // some exception example
        // Dummy scenario
        // String x = null
        //System.out.println(x.toUpperCase());

        bookStudentService.issueBook(bookId, toStudentId);


//        Book book = bookRepository.findById(bookId)
//                .orElseThrow(()->new ResourceNotFoundException(
//                        String.format("Book with id %s not found",bookId)
//                ));
//        Student student1 = studentRepository.findById(fromStudentId)
//                .orElseThrow(()->new ResourceNotFoundException(
//                        String.format("Student with id %s not found",fromStudentId)
//                ));
//
//        Set<BookStudent> booksIssued1 = student1.getBooksIssued();
//
//        long count1 = booksIssued1.stream().filter(bookIssue ->
//                        bookIssue.getBook() == book && bookIssue.getReturnDate() == null)
//                .count();
//
//        if (count1 == 0) {
//            throw new BookNotIssuedYetException(
//                    String.format("Book %s has not yet issued to student %s, can not return",book.getTitle(),student1.getUsername())
//            );
//        }
//        BookStudent bookStudent = bookStudentRepository
//                .findBookStudentByBookAndStudentAndReturnDateIsNull(
//                        book,
//                        student1
//                );
//        bookStudent.setReturnDate(new Date());
//        this.bookStudentRepository.save(bookStudent);
//
//        Student student2 = studentRepository.findById(fromStudentId)
//                .orElseThrow(()->new ResourceNotFoundException(
//                        String.format("Student with id %s not found",fromStudentId)
//                ));
//
//        Set<BookStudent> booksIssued2 = student2.getBooksIssued();
//
//        long count = booksIssued2.stream().filter(bookIssue ->
//                        bookIssue.getBook() == book && bookIssue.getReturnDate() == null)
//                .count();
//
//        if (count > 0) {
//            throw new BookAlreadyIssuedException(
//                    String.format("Book %s has already been issued to student %s, can not reissue",book.getTitle(),student2.getUsername())
//            );
//        }
//
//        BookStudent bookStudent2 = new BookStudent(book, student2, new Date());
//        this.bookStudentRepository.save(bookStudent);

    }
}
