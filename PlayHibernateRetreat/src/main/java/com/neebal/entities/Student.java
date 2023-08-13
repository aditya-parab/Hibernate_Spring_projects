package com.neebal.entities;

import javax.persistence.*;
import java.util.Set;
import java.util.logging.Level;

@Entity
@Table(name="students")
public class Student extends Person{



    @Column(nullable = true)
    private Integer roll;

    @OneToMany(mappedBy = "student")
    Set<BookStudent> booksIssued;

    public Set<BookStudent> getBooksIssued() {
        return booksIssued;
    }

    public void setBooksIssued(Set<BookStudent> booksIssued) {
        this.booksIssued = booksIssued;
    }



    public Student() {
    }

    public Student(String name, Character gender, Integer roll) {
        super(name,gender);
        this.roll = roll;
    }



    public Integer getRoll() {
        return roll;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", roll=" + roll +
                '}';
    }

    public void setRoll(Integer roll) {
        this.roll = roll;
    }
}
