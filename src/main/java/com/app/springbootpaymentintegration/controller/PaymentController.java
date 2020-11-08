package com.app.springbootpaymentintegration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PaymentController {

	@GetMapping("/payment")
	public String showPayment() {
		
	 return "payment" ;
	}
	
	@GetMapping("/payment-form")
	public String showPaymentForm() {
		
	 return "payment-form" ;
	}
	
	@PostMapping("/makePayment")
	public String makePayment() {
		
	 return "paymentSuccess" ;
	}
	
}
