package com.simplilearn.sporty.shoes.controller;

import com.simplilearn.sporty.shoes.model.Login;
import com.simplilearn.sporty.shoes.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collections;
import java.util.List;

@Controller
public class UsersController {

	@Autowired
	private LoginRepository loginRepository;

	@RequestMapping (value = "/viewUsersPage", method = RequestMethod.GET)
	public String viewCategoryPage(Model model) {
		model.addAttribute("users", new Login());
		List<Login> users = loginRepository.findAll();
		if(!users.isEmpty()){
			//log.info("[viewCategoryPage] categories will be shown in page! categories={}", categories);
			model.addAttribute("users", users);
			return "viewUsersPage";
		}
		//log.warn("[viewCategoryPage] there is no categories!");
		model.addAttribute("categoryInfo", "there isn't any category");
		model.addAttribute("category", Collections.emptyList());
		return "viewUsersPage";
	}
}
