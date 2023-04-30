package com.simplilearn.sporty.shoes.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Getter
@Setter
@ToString
public class Orders {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int orderId;

	@DateTimeFormat (pattern = "YYYY-mm-dd") // mysql default date format.

	private LocalDate orderplaced;
	private Integer productid;
	private String emailid;

}
