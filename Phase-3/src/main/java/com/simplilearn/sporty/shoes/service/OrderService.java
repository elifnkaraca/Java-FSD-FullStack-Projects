package com.simplilearn.sporty.shoes.service;

import com.simplilearn.sporty.shoes.model.Orders;
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

	public boolean insertOrder(Orders orders) {
		try {
			log.info("[insertOrder] started! record will be inserted! :: order ={}", orders);

			orderRepository.save(orders);
			log.info("[insertOrder] new order inserted! :: order ={}", orders);
			return true;

		} catch (Exception e) {
			log.error("[insertOrder] Exception occurred! Order could not be added!");
		}
		return false;
	}

	public List<Orders> getAllOrdersByEmail(String emailid) {
		List<Orders> ordersList = orderRepository.findByEmailid(emailid);
		if(!ordersList.isEmpty()) {
			return ordersList;
		} else {
			log.error("[getAllOrdersByEmail] Exception occurred! There is no order!");
		}
		return null;
	}

	public List<Orders> getAllOrders() {
		List<Orders> ordersList = orderRepository.findAll();
		if(!ordersList.isEmpty()) {
			return ordersList;
		} else {
			log.error("[getAllOrdersByEmail] Exception occurred! There is no order!");
		}
		return Collections.emptyList();
	}
}
