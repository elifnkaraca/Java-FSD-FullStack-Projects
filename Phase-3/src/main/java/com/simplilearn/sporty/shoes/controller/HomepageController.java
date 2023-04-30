package com.simplilearn.sporty.shoes.controller;

import com.simplilearn.sporty.shoes.model.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomepageController {

    @RequestMapping(value = "/signInPage", method = RequestMethod.GET)
    public String signInPage(Model model) {
        model.addAttribute("login", new Login());
        return "signInPage";
    }

    @RequestMapping(value = "/signUpPage", method = RequestMethod.GET)
    public String signUp(Model model){
        model.addAttribute("login", new Login());
        return "signUpPage";
    }

    @RequestMapping(value = "/adminHome", method = RequestMethod.GET)
    public String adminHome(){
        return "adminHome";
    }

    @RequestMapping(value = "/customerHome", method = RequestMethod.GET)
    public String customerHome(){
        return "customerHome";
    }
}
