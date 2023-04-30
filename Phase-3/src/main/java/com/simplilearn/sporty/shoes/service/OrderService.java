package com.simplilearn.sporty.shoes.service;


import com.simplilearn.sporty.shoes.model.Order;
import com.simplilearn.sporty.shoes.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;



	public boolean insertOrder(Order order) {
		try {
			log.info("[insertOrder] started! record will be inserted! :: category ={}", order);

			orderRepository.save(order);
			log.info("[insertOrder] new category inserted! :: category ={}", order);
			return true;

		} catch (Exception e) {
			log.error("[insertOrder] Exception occurred! Category could not be added!");
		}
		return false;
	}
}
