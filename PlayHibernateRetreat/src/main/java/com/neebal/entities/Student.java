package com.neebal.entities;

import javax.persistence.*;
import java.util.Set;
import java.util.logging.Level;

@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20,nullable = false)
    private String name;

    @Column(length = 1,nullable = false)
    private Character gender;

    @Column(nullable = false)
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
        this.name = name;
        this.gender = gender;
        this.roll = roll;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
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
