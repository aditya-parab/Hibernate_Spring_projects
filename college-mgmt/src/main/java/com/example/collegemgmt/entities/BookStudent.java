package com.example.collegemgmt.entities;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "bookstudents")
public class BookStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Book book;

    @ManyToOne
    private Student student;

    @Temporal(TemporalType.DATE)
    @Column(nullable = true)
    private Date issueDate;

    @Temporal(TemporalType.DATE)
    @Column(nullable = true)
    private  Date returnDate;

    public BookStudent() {
    }

    public BookStudent(Book book, Student student, Date issueDate, Date returnDate) {
        this.book = book;
        this.student = student;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
