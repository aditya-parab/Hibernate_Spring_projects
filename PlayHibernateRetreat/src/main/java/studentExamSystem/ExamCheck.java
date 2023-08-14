package studentExamSystem;

import com.neebal.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import studentExamSystem.entities.Exam;
import studentExamSystem.entities.ExamQuestion;
import studentExamSystem.entities.Question;

import java.util.ArrayList;
import java.util.List;

public class ExamCheck {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Exam selectedExam = session.get(Exam.class, 1l);
            List<ExamQuestion> examQuestions = new ArrayList<>(selectedExam.getExamQuestions());
            for (ExamQuestion examQuestion : examQuestions) {
                Question question = examQuestion.getQuestion();
                System.out.println(question.getDescr());
        }
    }
}}
