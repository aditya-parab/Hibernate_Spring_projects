package com.example.collegemgmt.services;

import com.example.collegemgmt.entities.Book;
import com.example.collegemgmt.entities.BookStudent;
import com.example.collegemgmt.entities.Student;
import com.example.collegemgmt.repository.BookRepository;
import com.example.collegemgmt.repository.StudentRepository;
import com.example.collegemgmt.repository.BookStudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.Date;
import java.util.Set;

@Service
public class BookStudentService {

//    @Autowired
    BookRepository bookRepository;

//    @Autowired
    StudentRepository studentRepository;

//    @Autowired
    BookStudentRepository bookStudentRepository;

    public BookStudentService() {
    }



    public BookStudentService(BookStudentService bookStudentService,
                                  StudentRepository studentRepository,
                                  BookStudentRepository bookStudentRepository) {
        this.bookStudentService = bookStudentService;
        this.studentRepository = studentRepository;
        this.bookStudentRepository = bookStudentRepository;
    }

    //self injection to call buisiness methods within the same services
    @Autowired
    @Lazy // to avoid circular dependency
            BookStudentService bookStudentService;

    @Autowired
    SendEmailService sendEmailService;

//    @Transactional
//    public BookStudent issueBook(long bookId, long studentId) throws Exception {
//        Book book = this.bookRepository.findBookById(bookId);
//        if (book == null) {
//
//            throw new Exception("Book not found");
//        }
//
//        if (this.bookStudentRepository.findBookStudentByBook(book).getReturnDate() == null && this.bookStudentRepository.findBookStudentByBook(book).getIssueDate() != null) {
//            throw new Exception("Book has been issued and yet not returned");
//        }
//
//        Student student = studentRepository.findStudentById(studentId);
//        if (student == null) {
//            throw new Exception("Student not found");
//        }
//
//        BookStudent bookStudent = new BookStudent();
//        bookStudent.setBook(book);
//        bookStudent.setStudent(student);
//        bookStudent.setIssueDate(new Date());
//        this.bookStudentRepository.save(bookStudent);
//        return bookStudent;
//    }

    @Transactional
    public BookStudent issueBook(Long bookId, Long studentId) throws Exception {

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
                .orElseThrow(()->new Exception("Book not found"));
        Student student = studentRepository.findById(studentId)
                .orElseThrow(()->new Exception("Student not found"));

        Set<BookStudent> booksIssued = student.getBooksIssued();

        long count = booksIssued.stream().filter(bookIssue ->
                        bookIssue.getBook() == book && bookIssue.getReturnDate() == null)
                .count();

        if (count > 0) {
            throw new Exception("Book already issued");
        }

        BookStudent bookStudent = new BookStudent(book, student, new Date(),null);
        this.bookStudentRepository.save(bookStudent);

        //send a confirmation email to the student
        String email = "adparab97@gmail.com";
        sendEmailService.sendMail(email,"great job aditya!");

        return bookStudent;
    }
//    @Transactional
//    public BookStudent returnBook(long bookId, long studentId) throws Exception {
//        Book book = this.bookRepository.findBookById(bookId);
//        if (book == null) {
//            throw new Exception("Book not found");
//        }
//
//        Student student= this.studentRepository.findStudentById(bookId);
//        if (student == null) {
//            throw new Exception("Student not found");
//        }
//
////        if (this.bookStudentRepository.findBookStudentByBook(book).getReturnDate() != null){
////            throw new Exception("Book was already returned");
////        }
//
//        Set<BookStudent> bookStudents = student.getBooksIssued();
//        for(BookStudent bookStudent:bookStudents){
//            if(bookStudent.getBook().equals(book)){
//                if(bookStudent.getReturnDate()!=null){
//                    throw new Exception("book was already returned");
//                }
//                else{
//                    bookStudent.setReturnDate(new Date());
//                    this.bookStudentRepository.save(bookStudent);
//                    return bookStudent;
//                }
//            }
//        }
//
//        //was unable to return book
//        return null;
//
//    }

    @Transactional
    public BookStudent returnBook(Long bookId, Long studentId) throws Exception {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(()->new Exception("Resource not found"));
        Student student = studentRepository.findById(studentId)
                .orElseThrow(()->new Exception("Resource not found"));

        Set<BookStudent> booksIssued = student.getBooksIssued();

        for (BookStudent bookIssue : booksIssued) {
            if (bookIssue.getBook() == book && bookIssue.getReturnDate() == null) {
                bookIssue.setReturnDate(new Date());
                bookStudentRepository.save(bookIssue);
                System.out.println("The book returned successfully!");
                return bookIssue;
            }
        }
        throw new Exception("The book hasn't been issued yet");



    }

//    @Transactional
//    public void transferStudent(Long bookId, Long fromStudentId,Long toStudentId) throws Exception {
//            BookStudent bookStudent1 = returnBook(bookId,fromStudentId);
//            bookStudentRepository.save(bookStudent1);
//
//            BookStudent bookStudent2 = issueBook(bookId,toStudentId);
//            bookStudentRepository.save(bookStudent2);
//
//    }

//    @Transactional
//    public void transferStudent(Long bookId, Long fromStudentId,Long toStudentId) throws Exception {
//        Book book = bookRepository.findById(bookId)
//                .orElseThrow(()->new Exception("Book not found"));
//        Student fromStudent = studentRepository.findById(fromStudentId)
//                .orElseThrow(()->new Exception("student not found"));
//
//        Set<BookStudent> bookStudent1 = fromStudent.getBooksIssued();
//        long c1 = bookStudent1
//                .stream()
//                .filter(
//                        bookStudent -> bookStudent.getBook().equals(book) && bookStudent.getReturnDate()==null
//               ).count();
//        if(c1==0){
//            throw new Exception("Book is not issued ")
//        }
//
//    }

//    @Transactional
//    public BookStudent transferBook(Long bookId, Long fromStudentId, Long toStudentId) throws Exception {
//        Book book = bookRepository.findById(bookId)
//                .orElseThrow(()->new Exception("Book not found"));
//        Student student1 = studentRepository.findById(fromStudentId)
//                .orElseThrow(()->new Exception("student not found"));
//
//        Set<BookStudent> booksIssued1 = student1.getBooksIssued();
//
//        long count1 = booksIssued1.stream().filter(bookIssue ->
//                        bookIssue.getBook() == book && bookIssue.getReturnDate() == null)
//                .count();
//
//        if (count1 == 0) {
//            throw new Exception("Book has not yet issued to student , can not return");
//
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
//                .orElseThrow(()->new Exception("Student with id  not found")
//                );
//
//        Set<BookStudent> booksIssued2 = student2.getBooksIssued();
//
//        long count = booksIssued2.stream().filter(bookIssue ->
//                        bookIssue.getBook() == book && bookIssue.getReturnDate() == null)
//                .count();
//
//        if (count > 0) {
//            throw new Exception(
//                    String.format("Book %s has already been issued to student %s, can not reissue",book.getTitle(),student2.getUsername())
//            );
//        }
//
//        BookStudent bookStudent2 = new BookStudent(book, student2, new Date(),null);
//        this.bookStudentRepository.save(bookStudent);
//        return bookStudent;
//
//    }

    @Transactional
    public void transferBook(Long bookId, Long fromStudentId, Long toStudentId) throws Exception {
        bookStudentService.returnBook(bookId,fromStudentId); //using self injection
        bookStudentService.issueBook(bookId,toStudentId);

    }




}
