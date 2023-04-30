package com.simplilearn.sporty.shoes.controller;

import com.simplilearn.sporty.shoes.model.Order;
import com.simplilearn.sporty.shoes.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Slf4j
@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping (value = "/createOrderPage", method = RequestMethod.GET)
	public String createOrderPage(Model model) {
		model.addAttribute("order", new Order());
		return "createOrderPage";
	}

	@RequestMapping(value = "/createOrder", method = RequestMethod.POST)
	public String createOrder(@ModelAttribute Order order, Model model){
		boolean categoryInserted = orderService.insertOrder(order);
		if(categoryInserted){
			return "addCategoryPage";
		}
		return "addCategoryPage";
	}

/*	@RequestMapping(value = "/viewOrderPage", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute Order order, Model model){
		List<Order> orderList = orderService.getAllOrdersByEmail(order.getEmailid());

		if(! orderList.isEmpty()){
			model.addAttribute("categoryInfoMessage","Category created!");
			return "viewOrderPage";
		}
		model.addAttribute("categoryInfoMessage","Category could not be created!");
		return "viewOrderPage";
	}*/
}
