package com.neebal.springexamSystem.controllers;

import com.neebal.springexamSystem.entities.Exam;
import com.neebal.springexamSystem.entities.StudentEntity;
import com.neebal.springexamSystem.entities.StudentExam;
import com.neebal.springexamSystem.repository.ExamRepository;
import com.neebal.springexamSystem.services.MasterDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@SessionAttributes({"student","studentExam"}) //names of attributes that we want SPRING MVC to remember for whole session
public class MainController {


    MasterDataService masterDataService;
    ExamRepository examRepository;



    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String initialWelcome(){

        return "welcome";

    }


    @RequestMapping(value = "/studentdetails", method = RequestMethod.GET)
    public String showLogin(){

        return "studentdetails";
    }

    @RequestMapping(value = "/studentdetails", method = RequestMethod.POST)
    public String processLogin(@RequestParam String name, MasterDataService masterDataService, Model model, RedirectAttributes redirectAttributes){
        this.masterDataService=masterDataService;
        StudentEntity student = masterDataService.setStudentName(name);
        model.addAttribute("student",student);

        StudentExam studentExam = masterDataService.setStudent(student);
        model.addAttribute("studentExam",student);

        redirectAttributes.addFlashAttribute("name",student.getName());
        masterDataService.getAllExams();





        return "redirect:/chooseexam";

    }

    @RequestMapping(value = "/chooseexam",method = RequestMethod.GET)
    public String chooseExamGet(ModelMap modelMap, @ModelAttribute("name")String name, ExamRepository examRepository) {
        this.examRepository=examRepository;
        modelMap.put("name",name);


        return "chooseexam";
    }
}
