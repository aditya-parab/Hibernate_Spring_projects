package com.example.collegemgmt.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 50)
    String username;

    @Column(nullable = false,length = 50)
    String password;

    @Column(nullable = true,length = 1)
    Character gender;

    @OneToMany(mappedBy = "student")
    Set<BookStudent> booksIssued;

    public Student(String username, String password, Character gender, Set<BookStudent> booksIssued) {
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.booksIssued = booksIssued;
    }

    public Set<BookStudent> getBooksIssued() {
        return booksIssued;
    }

    public void setBooksIssued(Set<BookStudent> booksIssued) {
        this.booksIssued = booksIssued;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Character getGender() {
        return gender;
    }


    public void setGender(Character gender) {
        this.gender = gender;
    }

    public Student() {
    }

    public Student(String username, String password, Character gender) {
        this.username = username;
        this.password = password;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                '}';
    }
}

