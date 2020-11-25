package com.app.springbootpaymentintegration.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.app.springbootpaymentintegration.dto.Cards;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.PaymentIntent;
import com.stripe.model.PaymentMethod;
import com.stripe.model.PaymentMethodCollection;

@Service
public class PaymentServiceImpl implements PaymentService {

	
	@Value("${app.stripePrivateKey}")
	private String stripePrivateKey;
	
	private PaymentIntent paymentIntent;
	
	@Override
	public String createStripeCustomer(String email,String name) {

		Stripe.apiKey =stripePrivateKey;
		Customer customer =null;
		Map<String, Object> customerParams = new HashMap<String, Object>();
		customerParams.put("description", name);
		customerParams.put("email", email);
		 Map<String, String> initialMetadata = new HashMap<String, String>();
			initialMetadata.put("user email", email );
			customerParams.put("metadata", initialMetadata);
		try {
			 customer = Customer.create(customerParams);
		} catch (StripeException e) {
			e.printStackTrace();
		}
		
		System.out.println("customer object"  + customer);
		return customer.getId();
	}


	@Override
	public PaymentIntent createPaymentIntent(double amount, String currency, String email,String customerEmail) {
		Stripe.apiKey = stripePrivateKey;

		Map<String, Object> paymentIntentParams = new HashMap<>();
		
		int chargeAmount = (int)(amount * 100);
		
		paymentIntentParams.put("amount", chargeAmount);
		paymentIntentParams.put("currency", currency);
		paymentIntentParams.put("description", email);
		paymentIntentParams.put("setup_future_usage", "on_session");

		ArrayList<String> paymentMethodTypes = new ArrayList<>();
		paymentMethodTypes.add("card");
		 Map<String, String> initialMetadata = new HashMap<String, String>();
			initialMetadata.put("userEmail", email );
			initialMetadata.put("customerEmail", customerEmail );

			paymentIntentParams.put("metadata", initialMetadata);
			paymentIntentParams.put("payment_method_types", paymentMethodTypes);

		try {
			 paymentIntent =	PaymentIntent.create(paymentIntentParams);
			 System.out.println("paymentIntent.. "   +  paymentIntent.toJson());
		} catch (StripeException e) {
			e.printStackTrace();
		}
		return paymentIntent;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public PaymentIntent retrievePaymentIntentByPaymentId(String paymentId) {
		Stripe.apiKey =stripePrivateKey;
		if(null!=paymentId){
			
			try {
				paymentIntent = PaymentIntent.retrieve(paymentId);
			} catch (StripeException e) {
				e.printStackTrace();
			}	
					}
		
		return paymentIntent;
	}

	@Override
	public PaymentMethod attachCardToCustomer(String paymentMethodId, String customerId) {
	Stripe.apiKey = stripePrivateKey;

		PaymentMethod paymentMethod=null;
		try {
			paymentMethod = PaymentMethod.retrieve(paymentMethodId);
						
		} catch (StripeException e) {
			e.printStackTrace();
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("customer", customerId);
		try {
			paymentMethod.attach(params);
		} catch (StripeException e) {
			e.printStackTrace();
		}

		return paymentMethod;
	}
	
	
	@Override
	public PaymentMethodCollection paymentMethodByCustomerId(String customerId) {
		Stripe.apiKey = stripePrivateKey;


		Map<String, Object> paymentmethodParams = new HashMap<String, Object>();
		paymentmethodParams.put("customer", customerId);
		paymentmethodParams.put("type", "card");
		PaymentMethodCollection customer = null;
		try {
			customer =  PaymentMethod.list(paymentmethodParams);
		} catch (StripeException e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public PaymentIntent chargeSavedCards(double amount, String currency, String userEmail, String paymentMethodId,
			String customerEmail,String stripeCustomerId) {
		Stripe.apiKey = stripePrivateKey;

		int chargeAmount = (int)(amount * 100);
		
		Map<String, Object> paymentIntentParams = new HashMap<String, Object>();
		paymentIntentParams.put("amount", chargeAmount);
		paymentIntentParams.put("currency", currency);
		paymentIntentParams.put("description", userEmail);
		paymentIntentParams.put("payment_method", paymentMethodId);
		paymentIntentParams.put("customer", stripeCustomerId);

		paymentIntentParams.put("confirm", true);
		 Map<String, String> initialMetadata = new HashMap<String, String>();
			initialMetadata.put("userEmail", userEmail );
			initialMetadata.put("customerEmail", customerEmail );

			paymentIntentParams.put("metadata", initialMetadata);
		try {
			paymentIntent=	PaymentIntent.create(paymentIntentParams);
			System.out.println("paymentIntent  @@@@  "   +   paymentIntent);
		} catch (StripeException e) {
			e.printStackTrace();
		}
		
		return paymentIntent;
	}

	@Override
	public boolean detachACardFromCustomer(String cardId) {
		Stripe.apiKey = stripePrivateKey;

		try {
		PaymentMethod	paymentMethod = PaymentMethod.retrieve(cardId);
		paymentMethod =paymentMethod.detach();

			} catch (StripeException e) {
				e.printStackTrace();
			}
	}

	

	@Override
	public List<Cards> getSavedCardListByCustomerId(String customerId) {
		PaymentMethodCollection paymentMethodCollection = paymentMethodByCustomerId(customerId);
		System.out.println("paymentMethodCollection....... "  + paymentMethodCollection);
		List<Cards> cardList = new ArrayList<Cards>();

		if(null!=paymentMethodCollection){
			
			List<PaymentMethod> list = paymentMethodCollection.getData();
			if(null!=list && !list.isEmpty()){
				
				for (PaymentMethod paymentMethod : list) {
					
					Cards cards = new Cards();
					cards.setBrand(paymentMethod.getCard().getBrand());
					cards.setCardId(paymentMethod.getId());
					cards.setExpMonth(paymentMethod.getCard().getExpMonth());
					cards.setExpYear(paymentMethod.getCard().getExpYear());
					cards.setLast4digit(paymentMethod.getCard().getLast4());
				     paymentMethod.getCard();
				     
				     cardList.add(cards);
					
				}
				
			}
	}
		
		System.out.println("cardList............ "   +  cardList);
		return cardList;

}

}
