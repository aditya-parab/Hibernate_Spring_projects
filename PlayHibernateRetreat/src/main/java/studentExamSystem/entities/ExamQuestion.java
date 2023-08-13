package studentExamSystem.entities;

import javax.persistence.*;

@Entity
public class ExamQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Exam exam;

    @ManyToOne
    private Question question;

    // Getters and setters
}
