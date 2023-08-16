package com.neebal.springexamSystem.controllers;


import com.neebal.springexamSystem.entities.ExamQuestion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes({"student","studentExam","examQuestions"})
public class ExamController {

    public ExamController() {
        System.out.println("Exam controller has started..");
    }


    @RequestMapping(value = "/exampage", method = RequestMethod.GET)
    public String chooseExamGet( @ModelAttribute("examQuestions") List<ExamQuestion> examQuestions, Model model,ModelMap modelMap) {
        System.out.println("In ExamPage get");
        for(ExamQuestion examQuestion: examQuestions){
            System.out.println(examQuestion.getQuestion().getDescr());
        }
//        model.addAttribute("examQuestions", examQuestions);
        modelMap.put("examQuestions", examQuestions);
        return "/exampage";
    }

    @RequestMapping(value="/examPage", method = RequestMethod.POST)
    public String submitAnswer() {
        // Process submitted answers and perform necessary actions

        return "redirect:/examPage"; // Redirect back to the exam page
    }
}
