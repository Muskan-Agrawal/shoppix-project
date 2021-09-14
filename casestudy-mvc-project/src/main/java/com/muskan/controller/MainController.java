package com.muskan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.muskan.bean.Orders;
import com.muskan.bean.Product;
import com.muskan.model.service.OrderService;
import com.order.exception.CodeNotFoundException;

@Controller
public class MainController {

	@Autowired
	OrderService orderService;
	
	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView loginCheck(@ModelAttribute("customerEmail") String customerEmail ) throws CodeNotFoundException{
		ModelAndView modelAndView=new ModelAndView("login");
		modelAndView.addObject("customerEmail", customerEmail);
		Orders order=orderService.findOrderByEmail(customerEmail);
		modelAndView.addObject("customer", order);
		String message;
		if(order==null) {
			message="Invalid Login Credentials";
			modelAndView.addObject("message", message);
			modelAndView.setViewName("loginFailed");
		}
		else {
			modelAndView.addObject("customer", order); //request scope
//			session.setAttribute("user", user);
			
			modelAndView.setViewName("index");
		}
		return modelAndView;
	}
	
	@RequestMapping("/hey")
	public ModelAndView firstController() {
		return new ModelAndView("login","message","adf");
	}
	
	@RequestMapping("/products")
	public ModelAndView selectProducts() {
		Orders order=new Orders();
		List<Product> products=orderService.getAllProducts();
		ModelAndView modelAndView=new ModelAndView("product","productList",products);
		modelAndView.addObject("selected",order.getOrderItem());
		modelAndView.addObject("select",new Product());
		return modelAndView;
	}
}
