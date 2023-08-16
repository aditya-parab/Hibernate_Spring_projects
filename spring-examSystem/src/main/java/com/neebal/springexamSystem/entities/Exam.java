package com.neebal.springexamSystem.entities;


import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table(name="exams")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToMany(mappedBy = "exam")
    private Set<ExamQuestion> examQuestions;

    @OneToMany(mappedBy = "exam")
    private Set<StudentExam> studentsEnrolled;



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<ExamQuestion> getExamQuestions() {
        return examQuestions;
    }

    public void setExamQuestions(Set<ExamQuestion> examQuestions) {
        this.examQuestions = examQuestions;
    }

    public Set<StudentExam> getStudentsEnrolled() {
        return studentsEnrolled;
    }

    public void setStudentsEnrolled(Set<StudentExam> studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }

    // Getters and setters
}
