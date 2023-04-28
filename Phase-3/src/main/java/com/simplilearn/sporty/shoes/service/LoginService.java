package com.simplilearn.sporty.shoes.service;

import com.simplilearn.sporty.shoes.entity.Login;
import com.simplilearn.sporty.shoes.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.simplilearn.sporty.shoes.constants.SportyShoesConstants.ADMIN;

@Service
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;

	public String signIn(Login login) {

		Login user = loginRepository.signIn(login.getEmailid(), login.getPassword(), login.getTypeofuser());
		if (user != null) {
			if (user.getTypeofuser().equalsIgnoreCase(ADMIN)) {
				return "Admin login successfully";
			} else {
				return "Customer login successfully";
			}
		} else {
			return "Invalid emailid or password!";
		}
	}
}
