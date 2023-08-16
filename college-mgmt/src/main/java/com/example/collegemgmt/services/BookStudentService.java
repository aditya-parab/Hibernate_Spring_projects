package com.example.collegemgmt.services;

import com.example.collegemgmt.entities.Book;
import com.example.collegemgmt.entities.BookStudent;
import com.example.collegemgmt.entities.Student;
import com.example.collegemgmt.repository.BookRepository;
import com.example.collegemgmt.repository.StudentRepository;
import com.example.collegemgmt.repository.BookStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BookStudentService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    BookStudentRepository bookStudentRepository;

    public BookStudent issueBook(long bookId,long studentId) throws Exception {
        Book book = this.bookRepository.findBookById(bookId);
        if(book==null){

            throw new Exception("Book not found");
        }

        if(this.bookStudentRepository.findBookStudentByBook(book).getReturnDate()==null && this.bookStudentRepository.findBookStudentByBook(book).getIssueDate()!=null){
            throw new Exception("Book has been issued and yet not returned");
        }

        Student student = studentRepository.findStudentById(studentId);
        if(student == null){
            throw new Exception("Student not found");
        }

        BookStudent bookStudent = new BookStudent();
        bookStudent.setBook(book);
        bookStudent.setStudent(student);
        bookStudent.setIssueDate(new Date());
        this.bookStudentRepository.save(bookStudent);
        return bookStudent;
    }

}
