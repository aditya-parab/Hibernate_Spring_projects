package com.neebal.springexamSystem.controllers;


import com.neebal.springexamSystem.entities.*;
import com.neebal.springexamSystem.repository.StudentAnswerRepository;
import com.neebal.springexamSystem.repository.StudentExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@SessionAttributes({"student","studentExam","examQuestions","currentQuestion","totalMarks","questionNumber"})
public class ExamController {

    @Autowired
    StudentAnswerRepository studentAnswerRepository;

    @Autowired
    StudentExamRepository studentExamRepository;

    public ExamController() {
        System.out.println("Exam controller has started..");
    }


    @RequestMapping(value = "/exampage", method = RequestMethod.GET)
    public String initialQuestionPage( @ModelAttribute("examQuestions") List<ExamQuestion> examQuestions, @ModelAttribute("studentExam") StudentExam studentExam,Model model,ModelMap modelMap) {
        int totalMarks=0;
        model.addAttribute("totalMarks",totalMarks);
        //TBD
        if (examQuestions.isEmpty()) {
            return "noQuestionsAvailable"; // Redirect to a page indicating no questions available
        }

        int initialQuestionNumber = 1;
        ExamQuestion firstQuestion = examQuestions.get(0);


        model.addAttribute("currentQuestion", firstQuestion);
        model.addAttribute("questionNumber", initialQuestionNumber);


        // Add studentExam to the session
        modelMap.addAttribute("studentExam", studentExam);
        modelMap.put("examQuestions", examQuestions);
        return "/exampage";
    }

    @RequestMapping(value = "/submitAnswer", method = RequestMethod.POST)
    public String submitAnswer(
            @RequestParam("chosenOption") Long chosenOptionId,
            @RequestParam("examQuestionId") Long examQuestionId,
            @ModelAttribute("examQuestions") List<ExamQuestion> examQuestions,
            @RequestParam("chosenOption") QuestionOption chosenOption,
            @ModelAttribute("studentExam") StudentExam studentExam,
            @ModelAttribute("currentQuestion")ExamQuestion currentQuestion,
            @ModelAttribute("totalMarks") int totalMarks,
            @ModelAttribute("questionNumber") int questionNumber,
            Model model) {

        // Record student's answer
        StudentAnswer studentAnswer = new StudentAnswer();

        studentAnswer.setStudentExam(studentExam);
        studentAnswer.setQuestion(currentQuestion.getQuestion());
        studentAnswer.setChosenOption(chosenOption);


//        studentAnswerRepository.save(studentAnswer);

        Set<QuestionOption> questionOptions = currentQuestion.getQuestion().getQuestionOptions();

        //calculate marks
        for(QuestionOption questionOption: questionOptions){
            if(chosenOption.getDescr().equals(questionOption.getDescr()) && questionOption.isCorrect()){
                totalMarks+=currentQuestion.getQuestion().getMarks();

            }
        }
        model.addAttribute("totalMarks",totalMarks);

        studentExam.setMarksObtained(totalMarks);

//        studentExamRepository.save(studentExam);

        // Increment question number for the next question

        System.out.println(questionNumber);
        questionNumber++;
        System.out.println(questionNumber);

        // Retrieve the next question or redirect to a result page if no more questions

        if (questionNumber <= examQuestions.size()) {
            ExamQuestion nextQuestion = examQuestions.get(questionNumber - 1);
            model.addAttribute("currentQuestion", nextQuestion);
            model.addAttribute("questionNumber", questionNumber);
            return "/exampage";
        }
        else{
            return "/resultPage";
        }





    }

    @RequestMapping(value = "/resultPage", method = RequestMethod.GET)
    public String resultsDisplay(@ModelAttribute("name") String name,@ModelAttribute("totalMarks") int totalMarks, ModelMap modelMap){
        modelMap.put("totalMarks",totalMarks);
        modelMap.put("name",name);

        return "resultPage";

    }
}
