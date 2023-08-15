package com.example.collegemgmt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class HomeController {
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String initialHomePage(@ModelAttribute("username") String username){
        System.out.println(username);
        return "home";

    }
}
