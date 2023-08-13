package studentExamSystem.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String descr;

    @Column(nullable = false)
    private int marks;

    @Column(nullable = true)
    private String answer;


    @ManyToOne
    private Topic topic;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "question")
    private Set<QuestionOption> questionOptions;

    @OneToMany(mappedBy = "question")
    private Set<ExamQuestion> examQuestions = new HashSet<>();


    public Question() {
    }

    public Question(String descr, int marks, String answer, Topic topic, Set<QuestionOption> questionOptions) {
        this.descr = descr;
        this.marks = marks;
        this.topic = topic;
        this.answer = answer;
        this.questionOptions = questionOptions;
    }
    public Question(String descr, int marks, String answer, Topic topic) {
        this.descr = descr;
        this.marks = marks;
        this.topic = topic;

    }

    public Question(String descr, int marks, String answer) {
        this.descr = descr;
        this.marks = marks;
        this.answer=answer;
    }

    public Question(String descr, int marks) {
        this.descr = descr;
        this.marks = marks;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }


    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Set<QuestionOption> getQuestionOptions() {
        return questionOptions;
    }

    public void setQuestionOptions(Set<QuestionOption> questionOptions) {
        this.questionOptions = questionOptions;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", descr='" + descr + '\'' +
                ", marks=" + marks +
                ", topic=" + topic +
                ", questionOptions=" + questionOptions +
                '}';
    }
}

