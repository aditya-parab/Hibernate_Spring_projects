package studentExamSystem;

import com.neebal.entities.Student;
import studentExamSystem.entities.*;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        // Create question options and questions
        QuestionOption qo1 = new QuestionOption("China", true);
        QuestionOption qo2 = new QuestionOption("India", false);
        QuestionOption qo3 = new QuestionOption("Brazil", false);
        QuestionOption qo4 = new QuestionOption("Australia", false);

        Question question1 = new Question("What is the most populous country?", 4, "China");
        Question question2 = new Question("What is the second most populous country?", 4, "India");
        Question question3 = new Question("What is the third most populous country?", 4, "China");

        qo1.setQuestion(question1);
        qo2.setQuestion(question1);
        qo3.setQuestion(question1);
        qo4.setQuestion(question1);

        qo1.setQuestion(question2);
        qo2.setQuestion(question2);
        qo3.setQuestion(question2);
        qo4.setQuestion(question2);

        qo1.setQuestion(question3);
        qo2.setQuestion(question3);
        qo3.setQuestion(question3);
        qo4.setQuestion(question3);

        Set<QuestionOption> questionOptions = new HashSet<>();
        questionOptions.add(qo1);
        questionOptions.add(qo2);
        questionOptions.add(qo3);
        questionOptions.add(qo4);

        question1.setQuestionOptions(questionOptions);
        question2.setQuestionOptions(questionOptions);
        question3.setQuestionOptions(questionOptions);

        // Create a set of questions for an exam
        Set<Question> examQuestions = new HashSet<>();
        examQuestions.add(question1);
        examQuestions.add(question2);
        examQuestions.add(question3);

        // Create an exam and associate questions using ExamQuestion
        Exam exam = new Exam();
        exam.setTitle("Sample Exam");

        Set<ExamQuestion> examQuestionSet = new HashSet<>();
        for (Question question : examQuestions) {
            ExamQuestion examQuestion = new ExamQuestion();
            examQuestion.setExam(exam);
            examQuestion.setQuestion(question);
            examQuestionSet.add(examQuestion);
        }
        exam.setExamQuestions(examQuestionSet);

        // Create a student
        StudentEntity studententity = new StudentEntity();
        studententity.setName("John");

        // Simulate student's exam answers
        StudentExam studentExam = new StudentExam();
        studentExam.setStudentEntity(studententity);
        studentExam.setExam(exam);

//// Simulate student's answers (assumes the student gets all answers correct)
//        for (ExamQuestion examQuestion : exam.getExamQuestions()) {
//            Question question = examQuestion.getQuestion();
//            StudentAnswer studentAnswer = new StudentAnswer();
//            studentAnswer.setQuestion(question);
//            studentAnswer.setChosenOption(question.getAnswer()); // Assuming answer matches option description
//            studentExam.getAnswers().add(studentAnswer);
//        }
//
//        // Calculate total marks
//        int totalMarks = 0;
//        for (StudentAnswer studentAnswer : studentExam.getAnswers()) {
//            Question question = studentAnswer.getQuestion();
//            String chosenOption = studentAnswer.getChosenOption();
//            Set<QuestionOption> questionOptions = question.getQuestionOptions();
//            for (QuestionOption option : questionOptions) {
//                if (option.isCorrect() && option.getDescr().equals(chosenOption)) {
//                    totalMarks += question.getMarks();
//                    break;
//                }
//            }
//        }
//
//        // Set the calculated marks and exam date
//        studentExam.setMarksObtained(totalMarks);
//        studentExam.setDateExamTaken(LocalDate.now());
//
//        // Print the calculated marks
//        System.out.println("The marks gained in this exam by the student are: " + totalMarks);
    }


}
