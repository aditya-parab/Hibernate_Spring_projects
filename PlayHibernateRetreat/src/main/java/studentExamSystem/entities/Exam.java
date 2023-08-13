package studentExamSystem.entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="exams")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToMany(mappedBy = "exam")
    private Set<ExamQuestion> examQuestions = new HashSet<>();

    @OneToMany(mappedBy = "exam")
    private Set<StudentExam> studentsEnrolled = new HashSet<>();

    // Getters and setters
}
