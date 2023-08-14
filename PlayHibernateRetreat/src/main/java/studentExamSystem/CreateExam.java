package studentExamSystem;

import com.neebal.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import studentExamSystem.entities.Exam;
import studentExamSystem.entities.ExamQuestion;
import studentExamSystem.entities.Question;

import java.util.*;

public class CreateExam {

    //make examquestion
    //exam.setExamquestionasas\\

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the exam title:");
        String examTitle = scanner.nextLine();
        Exam exam = new Exam();
        exam.setTitle(examTitle);

        Set<ExamQuestion> examQuestions = new HashSet<>();

        System.out.println("Enter the number of questions for the exam:");
        int numQuestions = scanner.nextInt();
        scanner.nextLine(); // Consume the newline


        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        //get questions
        try(Session session =  sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            for (int i = 1; i <= numQuestions; i++) {
                System.out.println("Enter the question ID:");
                long questionId = scanner.nextLong();
                Question question = session.get(Question.class,questionId);

                ExamQuestion examQuestion = new ExamQuestion();
                examQuestion.setExam(exam);
                examQuestion.setQuestion(question);

                examQuestions.add(examQuestion); //add the examquestion into the list of examquestions
                session.save(examQuestion);
            }
            exam.setExamQuestions(examQuestions);

            session.save(exam);

            transaction.commit();

        }



    }
}
