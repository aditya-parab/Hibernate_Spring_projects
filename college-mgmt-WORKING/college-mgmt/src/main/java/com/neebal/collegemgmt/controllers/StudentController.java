package com.neebal.collegemgmt.controllers;


import com.neebal.collegemgmt.Student;
import com.neebal.collegemgmt.services.GreetingService;
import com.neebal.collegemgmt.services.MasterDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalTime;

@Controller
@SessionAttributes("username")
public class StudentController {

    @Autowired
    private GreetingService greetingService;

    @Autowired
    private MasterDataService masterDataService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage(
            ModelMap modelMap,
            //@RequestParam(required = false) String registerSuccess
            @ModelAttribute("registerSuccess") String registerSuccess,
            @ModelAttribute("invalidCreds") String invalidCreds

            )
    {
//        System.out.println("called...");
        modelMap.put("greeting", greetingService.getGreeting());
        modelMap.put("registerSuccess", registerSuccess);
        modelMap.put("invalidCreds", invalidCreds);

        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegisterPage(ModelMap modelMap){

        modelMap.put("countries", this.masterDataService.getCountries());
        modelMap.put("greeting", greetingService.getGreeting());

        return "register";
    }


    /*@RequestMapping(value = "/register", method = RequestMethod.POST)
    public static String registerStudent(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String country,
            @RequestParam String gender
    ){
        System.out.println(username + " " + password + " "+ country+ " "+ gender);
        return null;
    }*/

    @RequestMapping(value = "/register" , method = RequestMethod.POST)
    public static String registerStudent(
            @ModelAttribute Student student,
            RedirectAttributes redirectAttributes
    ){
        System.out.println(student.getUsername() + "\n" + student.getPassword() + "\n"+ student.getCountry()+ "\n"+ student.getGender());

        // imagine Students data is persisted in the database
        // redirected to the url /login
        // return "redirect:/login?registerSuccess=1";
        redirectAttributes.addFlashAttribute(
                "registerSuccess",
                1
        );
        return "redirect:/login";
    }

    @RequestMapping(value = "/login" , method = RequestMethod.POST)
    public String authenticate(
            @RequestParam String username,
            @RequestParam String password,
            RedirectAttributes redirectAttributes,
            Model model
    ){
        Student student = this.masterDataService.authenticate(username,password);
        if(student==null){
            redirectAttributes.addFlashAttribute(
                    "invalidCreds",
                    1
            );
            return "redirect:/login";
        }
        else{

            model.addAttribute("username", username);
            return "redirect:/home";
        }

    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(SessionStatus sessionStatus){
        sessionStatus.setComplete(); // clears the model attributes form the session
        return "redirect:/login";
    }
}
