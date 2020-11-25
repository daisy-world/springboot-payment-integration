package com.app.springbootpaymentintegration.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.springbootpaymentintegration.dto.Cards;
import com.app.springbootpaymentintegration.model.UserDetails;
import com.app.springbootpaymentintegration.service.PaymentService;
import com.app.springbootpaymentintegration.service.UserService;
import com.stripe.model.PaymentIntent;
import com.stripe.model.PaymentMethod;

@Controller
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	@Autowired
	UserService userService;

	@GetMapping("/payment")
	public String showPayment() {
		
	 return "payment" ;
	}
	
	@PostMapping("/payment-form")
	public String showPaymentForm(HttpServletRequest request,ModelMap map, HttpSession httpSession) {
		String customerEmail = request.getParameter("customer-email");
		String amount = request.getParameter("amount");
		double payamount = Double.parseDouble(amount);
		String userEmail = (String) httpSession.getAttribute("email");
		map.put("customerEmail", customerEmail);
		map.put("amount", payamount);
		map.put("userEmail", userEmail);
		
		PaymentIntent paymentIntent = paymentService.createPaymentIntent(payamount, "INR",userEmail,customerEmail);
		String paymentResponse=paymentIntent.toJson();
		try {
			JSONObject object = new JSONObject(paymentResponse);
			String client_secret = object.getString("client_secret");
			System.out.println("client_secret... "   +  client_secret);
			map.put("clientSecret", client_secret);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		 UserDetails userDetails = userService.fetchUserByEmail(userEmail);
		 String stripeCustomerId = null;
		 if(null!=userDetails) {
			 stripeCustomerId=	userDetails.getStripe_customer_id(); 
		 }
		List<Cards> cards = paymentService.getSavedCardListByCustomerId(stripeCustomerId);
		System.out.println("existing card list ..... "   + cards );
		map.put("cards", cards);

		
	 return "payment-form" ;
	}
	
	@PostMapping("/payWithNewCard")
	public @ResponseBody String payWithNewCard(@RequestParam ("paymentId") String paymentId,
			                                @RequestParam ("remember") String remember,
			                                HttpSession httpSession) throws JSONException {
		
		
		System.out.println("remember.............. "   +  remember);

		PaymentIntent paymentIntent =paymentService.retrievePaymentIntentByPaymentId(paymentId); 
		String paymentResponse=paymentIntent.toJson();		
		System.out.println("payment Response............... "   +  paymentResponse);
		JSONObject  object =new JSONObject(paymentResponse);
		String response = null;
		 if (object.getString("status").equalsIgnoreCase("succeeded")) {
			 
			response =  "successful";
		 }else {
				response =  "failed";
 
		 }
		String userEmail = (String) httpSession.getAttribute("email");
		 UserDetails userDetails = userService.fetchUserByEmail(userEmail);
		 String stripeCustomerId = null;
		 if(null!=userDetails) {
			 stripeCustomerId=	userDetails.getStripe_customer_id(); 
		 }
		 String paymentMethodId =object.getString("payment_method"); 
			System.out.println("paymentMethodId.... "   +   paymentMethodId);
		 if(null!=remember && !remember.isEmpty()) {
			 
			 if(remember.equals("on")) {
				 
			PaymentMethod paymentMethod = paymentService.attachCardToCustomer(paymentMethodId, stripeCustomerId);
			System.out.println("paymentMethod... "   +paymentMethod);
		
				 
			 }
			 
		 }
			return response;
	}
	
	
	@PostMapping(value = "/payWithExistingCard")
	public @ResponseBody String payWithExistingCard(ModelMap map,
			@RequestParam("paymentMethodId") String paymentMethodId,
			@RequestParam("amount") double payAmount,
			@RequestParam("customerEmail") String customerEmail,
			HttpSession httpSession, HttpServletRequest request) throws JSONException {
		
		
		String userEmail = (String) httpSession.getAttribute("email");
		System.out.println("paymentMethodId.... "   +   paymentMethodId);
		System.out.println("amount.... "   +   payAmount);
		System.out.println("customerEmail.... "   +   customerEmail);
		 UserDetails userDetails = userService.fetchUserByEmail(userEmail);
		 String stripeCustomerId = null;
		 if(null!=userDetails) {
			 stripeCustomerId=	userDetails.getStripe_customer_id(); 
		 }
		PaymentIntent paymentIntent = paymentService.chargeSavedCards(payAmount, "INR", userEmail,paymentMethodId,customerEmail,stripeCustomerId);
		
		String paymentResponse = paymentIntent.toJson();
		
		System.out.println("existing card payment intent response@@@@@@@@@@ "   + paymentResponse );
		JSONObject jsonObject  = new JSONObject(paymentResponse);
		  
		String response = null;
		 if (jsonObject.getString("status").equalsIgnoreCase("succeeded")) {
			 
			response =  "successful";
		 }else {
				response =  "failed";

		 }
		return response;
		
		
	}
	
	@PostMapping(value = "/deleteCard")	
	public @ResponseBody String deleteCard( @RequestParam("cardId") String cardId){
		
		
				System.out.println("cardId ....... "   +  cardId);

		if(null!=cardId && !cardId.isEmpty()){
			
			paymentService.detachACardFromCustomer(cardId);
			
		}
		
}
}
