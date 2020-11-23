package com.app.springbootpaymentintegration.service;

import java.util.List;

import com.app.springbootpaymentintegration.dto.Cards;
import com.stripe.model.PaymentIntent;
import com.stripe.model.PaymentMethod;
import com.stripe.model.PaymentMethodCollection;

public interface PaymentService {
	
	public String createStripeCustomer(String email,String name);
	
	public PaymentIntent createPaymentIntent(double amount,String currency,String email,String customerEmail);

	public PaymentIntent retrievePaymentIntentByPaymentId(String paymentId);

	public PaymentMethod attachCardToCustomer(String paymentId,String customerId);

	public PaymentIntent chargeSavedCards(double amount, String currency, String userEmail, String paymentMethodId,String customerEmail,String stripeCustomerId);

	public boolean detachACardFromCustomer(String cardId);

	
	public List<Cards> getSavedCardListByCustomerId(String customerId);

	public PaymentMethodCollection paymentMethodByCustomerId(String customerId);
}
