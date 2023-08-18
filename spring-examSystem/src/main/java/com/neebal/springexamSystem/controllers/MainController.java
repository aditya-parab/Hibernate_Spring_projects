package com.neebal.springexamSystem.controllers;

import com.neebal.springexamSystem.entities.Exam;
import com.neebal.springexamSystem.entities.ExamQuestion;
import com.neebal.springexamSystem.entities.StudentEntity;
import com.neebal.springexamSystem.entities.StudentExam;
import com.neebal.springexamSystem.repository.ExamRepository;
import com.neebal.springexamSystem.repository.StudentEntityRepository;
import com.neebal.springexamSystem.services.MasterDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
@SessionAttributes({"student","name","studentExam","examQuestions"}) //names of attributes that we want SPRING MVC to remember for whole session
public class MainController {

    @Autowired
    MasterDataService masterDataService;
    @Autowired
    ExamRepository examRepository;
    @Autowired
    StudentEntityRepository studentEntityRepository;


    public MainController(){

        System.out.println("Main controller constructor is being called now.");
    }





    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String initialWelcome(){

        return "welcome";

    }


    @RequestMapping(value = "/studentdetails", method = RequestMethod.GET)
    public String showLogin(){

        return "studentdetails";
    }

    @RequestMapping(value = "/studentdetails", method = RequestMethod.POST)
    public String processLogin(@RequestParam String name, MasterDataService masterDataService, Model model, RedirectAttributes redirectAttributes, ModelMap modelMap){
        this.masterDataService=masterDataService;
        StudentEntity student = masterDataService.setStudentName(name);
        model.addAttribute("student",student);



        StudentExam studentExam = new StudentExam();
        studentExam.setStudentEntity(student);
        model.addAttribute("studentExam",studentExam);


//        studentEntityRepository.save(student);

        model.addAttribute("name",student.getName());




       List<Exam> examList= this.examRepository.findAll();

        model.addAttribute("examList",examList);


        return "/chooseexam";

    }

    @RequestMapping(value = "/chooseexam",method = RequestMethod.GET)
    public String chooseExamGet(ModelMap modelMap, Model model, @ModelAttribute("name")String name) {

        model.addAttribute("name",name);


        return "chooseexam";
    }

    @RequestMapping(value = "/chooseexam",method = RequestMethod.POST)
    public String chooseExamPost(ModelMap modelMap, @RequestParam("examChosenTitle") String examChosenTitle,
                                 @ModelAttribute("studentexam") StudentExam studentExam,Model model) {
        List<Exam> examList= this.examRepository.findAll();
        Exam selectedExam = new Exam();
        for(Exam exam : examList){
            if(exam.getTitle().equals(examChosenTitle)){
                selectedExam = exam;
            }
        }

        studentExam.setDateExamTaken(new Date());
        studentExam.setExam(selectedExam);
        List<ExamQuestion> examQuestions = new ArrayList<>(selectedExam.getExamQuestions());

            model.addAttribute("examQuestions", examQuestions);


        return "redirect:/exampage";
    }



}
