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


    @Column(nullable = true)
    private int marksObtained;

    @Column(nullable = false)
    private Date dateExamTaken;

}
