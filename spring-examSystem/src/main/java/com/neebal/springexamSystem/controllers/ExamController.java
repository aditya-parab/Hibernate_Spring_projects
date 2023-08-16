package com.neebal.springexamSystem.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"student","studentExam","examQuestions"})
public class ExamController {

}
