package com.example.collegemgmt.controllers;

import com.example.collegemgmt.services.GreetingsService;
import com.example.collegemgmt.services.MasterDataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalTime;
import java.util.List;

@Controller
public class StudentController {


    GreetingsService greetingsService;
    MasterDataService masterDataService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String initialLoginPage(ModelMap modelMap,GreetingsService greetingsService){
        this.greetingsService = greetingsService;
       String message = greetingsService.getGreetingByTime();
        modelMap.put("greeting",message);
        return "login";

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage(ModelMap modelMap,GreetingsService greetingsService){
        this.greetingsService = greetingsService;
        String message = greetingsService.getGreetingByTime();
        modelMap.put("greeting",message);
        return "login";
    }



    @RequestMapping(value="/registration",method = RequestMethod.GET)
    public String showRegisterPage(ModelMap modelMap,GreetingsService greetingsService, MasterDataService masterDataService) {
this.masterDataService=masterDataService;
        this.greetingsService = greetingsService;
        String message = greetingsService.getGreetingByTime();

       List<String> countries= this.masterDataService.getCountries();
        modelMap.put("countries",countries);
        modelMap.put("greeting",message);
        return "registration";
    }


}
