//package studentExamSystem;
//
//import studentExamSystem.entities.Question;
//import studentExamSystem.entities.QuestionOption;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class CalculateMarksInQuestion {
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
//
//        int marks=0;
//        for (QuestionOption option : questionOptions) {
//            if(option.isCorrect() && option.getDescr().equals(question.getAnswer())){
//                marks= question.getMarks();
//                break;
//            }
//        }
//        System.out.println("The marks gained in this question by Student are: "+marks);
//
//    }
//}
