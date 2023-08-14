package studentExamSystem;

import com.neebal.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import studentExamSystem.entities.Question;
import studentExamSystem.entities.QuestionOption;
import studentExamSystem.entities.Topic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static studentExamSystem.CreateQuestion.createQuestion;

public class CreateTopic {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the topic name:");
        String topicName = scanner.nextLine();
        Topic topic = new Topic(topicName);


        Set<Question> questions = new HashSet<>();

        System.out.println("Enter the number of questions for the topic:");
        int numQuestions = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        for (int i = 1; i <= numQuestions; i++) {
            // Reuse the CreateQuestion logic here
            Question question = createQuestion(scanner);
            question.setTopic(topic);
            questions.add(question);
        }


        topic.setQuestions(questions);

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(topic);

            // Save the associated questions along with their options
            for (Question question : questions) {
                session.save(question);
                for (QuestionOption option : question.getQuestionOptions()) {
                    option.setQuestion(question);
                    session.save(option);
                }
            }

            transaction.commit();
        }

        sessionFactory.close();
        scanner.close();
    }


}
