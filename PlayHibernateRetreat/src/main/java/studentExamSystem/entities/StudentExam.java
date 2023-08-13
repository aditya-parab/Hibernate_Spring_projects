package studentExamSystem.entities;


import com.neebal.entities.Student;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name="studentexams")
public class StudentExam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Exam exam;

    @ManyToOne
    private StudentEntity studentEntity;

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

    @Column(nullable = false)
    private Date dateExamTaken;

}
