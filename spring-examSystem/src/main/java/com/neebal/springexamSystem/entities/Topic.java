package com.neebal.springexamSystem.entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "topics")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(nullable = false)
    private String name;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "topic") //each question has a foreign key to Topic
    private Set<Question> questions;


    public Topic() {
    }

    public Topic(long id, String name, Set<Question> questions) {
        Id = id;
        this.name = name;
        this.questions = questions;
    }

    public Topic(String name) {

        this.name = name;
    }


    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", questions=" + questions +
                '}';
    }
}
