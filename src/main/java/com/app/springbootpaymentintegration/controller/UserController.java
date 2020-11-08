package com.app.springbootpaymentintegration.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.springbootpaymentintegration.model.UserDetails;
import com.app.springbootpaymentintegration.service.UserService;


@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/signup")
	
	public String showDashboard(HttpServletRequest request) {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userEmail =request.getParameter("userEmail") ;
		String userPass = request.getParameter("userPass");
		String userConfirmPass = request.getParameter("userConfirmPass");
		
		System.out.println("firstName.... "  + lastName + "userEmail..... " +  userEmail +  "userConfirmPass....... " + userConfirmPass);
		UserDetails userDetails = userService.addAccount(firstName,lastName, userEmail, userPass, userConfirmPass);
		return "login";
	}
	
	
	@GetMapping("/users")
	public String showUsers(ModelMap map) {
		
		List<UserDetails> users = userService.getUserList();
		System.out.println("all user list ..... "  + users.size() );
		map.put("users",users);
		return "users" ;
	}
	
	

}
