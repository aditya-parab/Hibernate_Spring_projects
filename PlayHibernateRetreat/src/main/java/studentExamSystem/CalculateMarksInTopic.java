package studentExamSystem;

import studentExamSystem.entities.Question;
import studentExamSystem.entities.QuestionOption;
import studentExamSystem.entities.Topic;

import java.util.HashSet;
import java.util.Set;

public class CalculateMarksInTopic {

    public static void main(String[] args) {
     //Question 1
        QuestionOption qo1 = new QuestionOption("China",true);
        QuestionOption qo2 = new QuestionOption("India",false);
        QuestionOption qo3 = new QuestionOption("Brazil",false);
        QuestionOption qo4 = new QuestionOption("Australia",false);

        Question question1 = new Question("What is the most populous country",4,"China");

        qo1.setQuestion(question1);
        qo2.setQuestion(question1);
        qo3.setQuestion(question1);
        qo4.setQuestion(question1);

        Set<QuestionOption> questionOptions = new HashSet<QuestionOption>();
        questionOptions.add(qo1);
        questionOptions.add(qo2);
        questionOptions.add(qo3);
        questionOptions.add(qo4);

        question1.setQuestionOptions(questionOptions);

//Question 2
        qo1 = new QuestionOption("China",true);
        qo2 = new QuestionOption("India",false);
        qo3 = new QuestionOption("Brazil",false);
        qo4 = new QuestionOption("Australia",false);

        Question question2 = new Question("What is the most populous country",4,"India");

        qo1.setQuestion(question2);
        qo2.setQuestion(question2);
        qo3.setQuestion(question2);
        qo4.setQuestion(question2);

        questionOptions = new HashSet<QuestionOption>();
        questionOptions.add(qo1);
        questionOptions.add(qo2);
        questionOptions.add(qo3);
        questionOptions.add(qo4);

        question2.setQuestionOptions(questionOptions);


        //Question 3
        qo1 = new QuestionOption("China",true);
        qo2 = new QuestionOption("India",false);
        qo3 = new QuestionOption("Brazil",false);
        qo4 = new QuestionOption("Australia",false);

        Question question3 = new Question("What is the most populous country",4,"China");

        qo1.setQuestion(question3);
        qo2.setQuestion(question3);
        qo3.setQuestion(question3);
        qo4.setQuestion(question3);

        questionOptions = new HashSet<QuestionOption>();
        questionOptions.add(qo1);
        questionOptions.add(qo2);
        questionOptions.add(qo3);
        questionOptions.add(qo4);

        question3.setQuestionOptions(questionOptions);

        //making a set of questions
        Set<Question> questions = new HashSet<>();
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);

        Topic topic =  new Topic("Geography");
        topic.setQuestions(questions);

        int marks=0;
        for (Question question : questions) {
            questionOptions = question.getQuestionOptions();
            for (QuestionOption option : questionOptions) {
                if(option.isCorrect() && option.getDescr().equals(question.getAnswer())){
                    marks+= question.getMarks();
                    break;
                }
            }
        }
        System.out.println("The marks gained in this question by Student are: "+marks);








    }
}
