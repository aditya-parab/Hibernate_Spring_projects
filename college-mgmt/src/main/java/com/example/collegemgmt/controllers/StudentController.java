package com.example.collegemgmt.controllers;

import com.example.collegemgmt.Student;
import com.example.collegemgmt.services.GreetingsService;
import com.example.collegemgmt.services.MasterDataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;

@Controller
@SessionAttributes("username") //names of attributes that we want SPRING MVC to remember for whole session
public class StudentController {


    GreetingsService greetingsService;
    MasterDataService masterDataService;


    //*****************GET*********************************

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String initialLoginPage(ModelMap modelMap,GreetingsService greetingsService){
        this.greetingsService = greetingsService;
       String message = greetingsService.getGreetingByTime();
        modelMap.put("greeting",message);
        return "login";

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage(ModelMap modelMap,GreetingsService greetingsService,
                                @ModelAttribute("registerSuccess") String registerSuccess,
                                @ModelAttribute("invalidCreds") String invalidCreds){
        this.greetingsService = greetingsService;

        String message = greetingsService.getGreetingByTime();
        modelMap.put("greeting",message);
        modelMap.put("registerSuccess",registerSuccess);
        modelMap.put("invalidCreds",invalidCreds);


        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(SessionStatus sessionStatus){
        System.out.println("logged out");
        sessionStatus.setComplete();

        return "redirect:/login";
    }

    //*****************POST*********************************



    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String authenticateLogin(ModelMap modelMap, MasterDataService masterDataService,
                                    @RequestParam String username,@RequestParam String password,
                                    RedirectAttributes redirectAttributes, Model model){

        this.masterDataService = masterDataService;

       Student student =  masterDataService.authenticate(username, password);
        if(student==null){
            redirectAttributes.addFlashAttribute("invalidCreds",1);
            return "redirect:/login";
        }
        else {
            modelMap.addAttribute("username",username);

            return "redirect:/home";
        }




    }


    @RequestMapping(value="/registration",method = RequestMethod.GET)
    public String showRegisterPage(ModelMap modelMap,
                                   GreetingsService greetingsService,
                                   MasterDataService masterDataService) {
this.masterDataService=masterDataService;
        this.greetingsService = greetingsService;
        String message = greetingsService.getGreetingByTime();

       List<String> countries= this.masterDataService.getCountries();
        modelMap.put("countries",countries);
        modelMap.put("greeting",message);
        return "registration";
    }

//    @RequestMapping(value = "/registration", method = RequestMethod.POST)
//    public String registerService(@RequestParam String username,
//    @RequestParam String password, @RequestParam String country, @RequestParam String gender){
//        System.out.println(username+ " "+password+" "+country+" "+gender);
//        return null;
//    }
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerService(@ModelAttribute  Student student, RedirectAttributes redirectAttributes){
//        System.out.println(student.getUsername()+ " "+student.getPassword()+" "+student.getCountry()+" "+student.getGender());

        //needs to be redirected to url /login but this time also passing in registerSuccess
        //one way
//        return "redirect:/login?registerSuccess=1";

        //nicer way
        redirectAttributes.addFlashAttribute("registerSuccess",1);

        return "redirect:/login";
    }






}
