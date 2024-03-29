package com.simplilearn.sporty.shoes.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
public class Orders {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int orderId;

	@DateTimeFormat (pattern = "yyyy-MM-dd")
	private LocalDate orderplaced;

	private Integer productid;

	private String emailid;
}
