package com.neebal.springexamSystem.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "studentanswers")
public class StudentAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private StudentExam studentExam;

    @ManyToOne
    private Question question;

    @ManyToOne
    private QuestionOption chosenOption;

    public StudentExam getStudentExam() {
        return studentExam;
    }

    public void setStudentExam(StudentExam studentExam) {
        this.studentExam = studentExam;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public QuestionOption getChosenOption() {
        return chosenOption;
    }

    public void setChosenOption(QuestionOption chosenOption) {
        this.chosenOption = chosenOption;
    }



    // Getters and setters
}

