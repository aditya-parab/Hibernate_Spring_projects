package com.neebal.springexamSystem.entities;

import com.neebal.springexamSystem.entities.Question;
import jakarta.persistence.*;

@Entity
@Table(name = "questionoptions")
public class QuestionOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(nullable = false)
    private String descr;

    @Column(nullable = false)
    private boolean correct;

    @ManyToOne
    private Question question;

    public QuestionOption() {
    }



    public QuestionOption(String descr, boolean correct) {

        this.descr = descr;
        this.correct=correct;

    }

    public QuestionOption(String descr, boolean correct, Question question) {

        this.descr = descr;
        this.correct=correct;
        this.question = question;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }


    @Override
    public String toString() {
        return "QuestionOption{" +
                "id=" + id +
                ", descr='" + descr + '\'' +
                ", question=" + question +
                '}';
    }
}
