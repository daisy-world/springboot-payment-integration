package com.app.springbootpaymentintegration.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
@GetMapping("/user/{name}/{email}")
	
	public String fetchEmployeeById(@PathVariable("email") String email,
			@PathVariable("name") String name) {
	
	
	System.out.println("email........... "  +   email);
		
		return email;
		
		
	}

}
