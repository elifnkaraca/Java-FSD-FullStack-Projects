package com.simplilearn.sporty.shoes.controller;

import com.simplilearn.sporty.shoes.entity.Login;
import com.simplilearn.sporty.shoes.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping (value = "/", method = RequestMethod.GET)
	public String open(Model model, Login login) {
		model.addAttribute("login", login);
		return "index";
	}

	@RequestMapping (value = "/signIn", method = RequestMethod.POST)
	public String signIn(Login login, HttpSession httpSession) {

		String response = loginService.signIn(login);

		if (response.equals("Customer login successfully")) {
			httpSession.setAttribute("emailid", login.getEmailid());
			return "customerHome";
		} else
			if (response.equals("Admin login successfully")) {
				return "adminHome";
			} else {
				return "index";
			}
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String signUp(@ModelAttribute Login login, Model model) {
		String result = loginService.signUp(login);

		if(result.equals("Account created successfully")) {
			return "customerHome";
		}
		model.addAttribute("errorMessage", result);
		return "signUpPage";
	}

	@RequestMapping(value = "/signUpPage", method = RequestMethod.GET)
	public String signUp(Model model){
		model.addAttribute("login", new Login());
		return "signUpPage";
	}
}
