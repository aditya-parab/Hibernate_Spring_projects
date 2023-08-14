package studentExamSystem;

import com.neebal.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import studentExamSystem.entities.StudentEntity;
import studentExamSystem.entities.*;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        int totalMarks=0;

        Scanner scanner = new Scanner(System.in);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            System.out.println("Enter the Name of student:");
            String sname = scanner.nextLine();
            StudentEntity student = new StudentEntity();
            student.setName(sname);

            StudentExam studentExam = new StudentExam();
            studentExam.setStudentEntity(student);


            System.out.println("Enter the Exam id you want to take?");
            long examId = scanner.nextLong();
            scanner.nextLine(); // Consume the newline character left in the buffer
            Exam selectedExam = session.get(Exam.class, examId);
            studentExam.setDateExamTaken(new Date());
            studentExam.setExam(selectedExam);
            List<ExamQuestion> examQuestions = new ArrayList<>(selectedExam.getExamQuestions());

            for (ExamQuestion examQuestion : examQuestions) {
                Question question = examQuestion.getQuestion();
                Set<QuestionOption> questionOptions = question.getQuestionOptions();

                System.out.println("The Question: " + question.getDescr());

                for(QuestionOption questionOption: questionOptions){
                    System.out.println(questionOption.getDescr());
                }

                //take student's answer string and set as chosenOption
                System.out.println("What is your answer?");
                String answer = scanner.nextLine();
                QuestionOption chosenOption = new QuestionOption();
                chosenOption.setDescr(answer);

                session.save(chosenOption);


                // Record student's answer
                StudentAnswer studentAnswer = new StudentAnswer();
                studentAnswer.setStudentExam(studentExam);
                studentAnswer.setQuestion(question);
                studentAnswer.setChosenOption(chosenOption);

                session.save(studentAnswer);

                //calculate marks
                for(QuestionOption questionOption: questionOptions){
                    if(chosenOption.getDescr().equals(questionOption.getDescr()) && questionOption.isCorrect()){
                        totalMarks+=question.getMarks();

                    }
                }


            }
        studentExam.setMarksObtained(totalMarks);

            session.save(student);
            session.save(studentExam);
            session.save(selectedExam);
            transaction.commit();

        }
        System.out.println("The student's total marks are "+totalMarks);
    }}


