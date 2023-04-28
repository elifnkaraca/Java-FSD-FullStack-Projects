package com.simplilearn.sporty.shoes.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class Login {

	@Id
	private String emailid;
	private String password;
	private String typeofuser;
}
