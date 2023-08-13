//package studentExamSystem;
//
//import com.neebal.HibernateUtil;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import studentExamSystem.entities.Question;
//import studentExamSystem.entities.QuestionOption;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class CreateQuestion {
//
//    public static void main(String[] args) {
//        QuestionOption qo1 = new QuestionOption("China",true);
//        QuestionOption qo2 = new QuestionOption("India",false);
//        QuestionOption qo3 = new QuestionOption("Brazil",false);
//        QuestionOption qo4 = new QuestionOption("Australia",false);
//
//        Question question = new Question("What is the most populous country",4,"China");
//
//        qo1.setQuestion(question);
//        qo2.setQuestion(question);
//        qo3.setQuestion(question);
//        qo4.setQuestion(question);
//
//        Set<QuestionOption> questionOptions = new HashSet<QuestionOption>();
//        questionOptions.add(qo1);
//        questionOptions.add(qo2);
//        questionOptions.add(qo3);
//        questionOptions.add(qo4);
//
//        question.setQuestionOptions(questionOptions);
//
//        SessionFactory sessionFactory =  HibernateUtil.getSessionFactory();
//
//        try(Session session = sessionFactory.openSession()) {
//            Transaction transaction = session.beginTransaction();
//            session.save(question);
//            transaction.commit();
//        }
//
//
//
//    }
//}

package studentExamSystem;

import com.neebal.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import studentExamSystem.entities.Question;
import studentExamSystem.entities.QuestionOption;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CreateQuestion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the question:");
        String questionText = scanner.nextLine();



        Set<QuestionOption> questionOptions = new HashSet<>();
        String correctAnswer="";
        int flag=0;         //functionality to ask if option only till correct option is told
        for (int i = 1; i <= 4; i++) {
            System.out.println("Enter option " + i + ":");
            String optionText = scanner.nextLine();
            QuestionOption questionOption = new QuestionOption(optionText, false);
            if(flag==0){
            System.out.println("Is this option correct? (true/false):");
            boolean isCorrect = scanner.nextBoolean();
            scanner.nextLine();
            if(isCorrect){
                flag=1;
                questionOption.setCorrect(true);
                correctAnswer=optionText;

            }

            }


            questionOptions.add(questionOption);
        }

        System.out.println("Enter the marks for the question:");
        int marks = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

//        System.out.println("Enter the correct answer for the question:");
//        String correctAnswer = scanner.nextLine();

        Question question = new Question(questionText, marks, correctAnswer);
        question.setQuestionOptions(questionOptions);

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(question);

            // Save the associated question options
            for (QuestionOption option : questionOptions) {
                option.setQuestion(question);
                session.save(option);
            }

            transaction.commit();
        }

        sessionFactory.close();
        scanner.close();
    }
}

