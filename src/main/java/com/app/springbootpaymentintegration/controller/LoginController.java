package com.app.springbootpaymentintegration.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.springbootpaymentintegration.model.UserDetails;
import com.app.springbootpaymentintegration.service.UserService;


@Controller
public class LoginController {

	 Logger logger = Logger.getLogger(LoginController.class);
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String showLogin() {
		
		
		return "login" ;
	}
	
	
  
	@PostMapping("/login")
	
	public String showDashboard(HttpServletRequest request,ModelMap map,
			                   HttpSession httpSession) {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		logger.info("email... "  +  email);
		logger.info("password... "  +  password);
		UserDetails userDetails = userService.fetchUserByEmail(email);
		if(null==userDetails) {
			logger.error("userDetails object null........." + userDetails);

		}
		
		httpSession.setAttribute("name", userDetails.getFirst_name());
		if( password.equals(userDetails.getConfirm_password())){
			logger.debug("password & db password should match  "  +  password   +" " +  userDetails.getConfirm_password() );

			return "dashboard";	

		}else {
			map.put("errorMessage", "*EmailId & Password does not match.");
			return "login";		
		}
		
		
	}
	
	@GetMapping("/logout")
	public String logout() {
		
		System.out.println("user logout successfully");
		return "login" ;
	}
	
	@GetMapping("/changePassword")
	public String changePassword(HttpServletRequest request) {
	return "changePassword" ;
	}

	@PostMapping("/resetPassword")
	public String resetPassword(HttpServletRequest request) {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");	
		String newPassword = request.getParameter("newPassword");	
		
		System.out.println("email..... "  +  email  +  "password...... "  +  password  + "newPassword... "  +  newPassword);
		userService.updatePassword(email,newPassword);
		
	return "login" ;
	}
	
	@PostMapping("/forgetPassword")
	public String forgetPassword(HttpServletRequest request,ModelMap map) {
		
		String email = request.getParameter("email");
		System.out.println("email...."   +   email);
		UserDetails userDetails = userService.fetchUserByEmail(email);
		System.out.println("userDetails.......... "  +  userDetails);
		if(null!=userDetails) {
			map.put("email", email);
			return "forgetPassword" ;

		}else {
			map.put("errorMessage", "**EmailId not found!");

			return "login" ;	
		}

	}
	
	@GetMapping("/dashboard")
	public String showDashboard() {
		
		
		return "dashboard" ;
	}

}
