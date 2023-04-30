package com.simplilearn.sporty.shoes.controller;

import com.simplilearn.sporty.shoes.model.Orders;
import com.simplilearn.sporty.shoes.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collections;
import java.util.List;

@Slf4j
@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping (value = "/createOrderPage", method = RequestMethod.GET)
	public String createOrderPage(Model model) {
		model.addAttribute("orders", new Orders());
		return "createOrderPage";
	}

	@RequestMapping (value = "/createOrder", method = RequestMethod.POST)
	public String createOrder(@ModelAttribute Orders orders, Model model) {
		boolean categoryInserted = orderService.insertOrder(orders);
		if (categoryInserted) {
			model.addAttribute("categoryInfoMessage", "Category created!");
			return "createOrderPage";
		}
		model.addAttribute("categoryInfoMessage", "Category cannot be created!");
		return "createOrderPage";
	}

	@RequestMapping (value = "/viewOrdersPage", method = RequestMethod.GET)
	public String viewOrdersPage(Model model, @ModelAttribute Orders orders) {
		model.addAttribute("orders", new Orders());
		List<Orders> orderList = orderService.getAllOrders();
		if (!orderList.isEmpty()) {
			log.info("[viewOrdersPage] orders will be shown in page! orders={}", orders);
			model.addAttribute("orders", orderList);
			return "viewOrdersPage";
		}
		log.warn("[viewOrdersPage] there is no orders!");
		model.addAttribute("orderInfo", "there is no any order yet");
		model.addAttribute("orders", Collections.emptyList());
		return "viewOrdersPage";
	}

}
