package com.neebal.springexamSystem.entities;





import jakarta.persistence.*;
import java.io.Serializable;
import java.util.*;


@Entity
@Table(name="studentexams")
public class StudentExam  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    private Exam exam;


    @ManyToOne
    private StudentEntity studentEntity;

    @OneToMany(mappedBy = "studentExam", cascade = CascadeType.ALL) // Define the mapping
    private List<StudentAnswer> studentAnswers = new ArrayList<>(); // Store student answers

    public List<StudentAnswer> getStudentAnswers() {
        return studentAnswers;
    }

    public void setStudentAnswers(List<StudentAnswer> studentAnswers) {
        this.studentAnswers = studentAnswers;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    public int getMarksObtained() {
        return marksObtained;
    }

    public void setMarksObtained(int marksObtained) {
        this.marksObtained = marksObtained;
    }

    public Date getDateExamTaken() {
        return dateExamTaken;
    }

    public void setDateExamTaken(Date dateExamTaken) {
        this.dateExamTaken = dateExamTaken;
    }

    @Column(nullable = true)
    private int marksObtained;

    @Temporal(TemporalType.DATE)
    @Column(nullable = true)
    private Date dateExamTaken;

}
