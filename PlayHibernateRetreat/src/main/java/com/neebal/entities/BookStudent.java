package com.neebal.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="book_students")
public class BookStudent implements Serializable {

    //***composite key***
    @Id
    @ManyToOne
    private Book book;

    @Id
    @ManyToOne
    private Student student;

    //***composite key***

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date issuedDate;

    @Temporal(TemporalType.DATE)
    @Column(nullable = true)
    private Date returnDate;

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

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public BookStudent() {
    }

    public BookStudent(Student student,Book book, Date issuedDate) {
        this.student = student;
        this.book=book;
        this.issuedDate = issuedDate;
    }

    @Override
    public String toString() {
        return "BookStudent{" +
                "book=" + book +
                ", student=" + student +
                ", issuedDate=" + issuedDate +
                '}';
    }
}
