package com.app.springbootpaymentintegration.service;

import com.app.springbootpaymentintegration.dto.Cards;
import com.stripe.model.PaymentIntent;
import com.stripe.model.PaymentMethod;

public interface PaymentService {
	
	public String createStripeCustomer(String email);
	
	public PaymentIntent createPaymentIntent(double amount,String currency,String email);

	public PaymentIntent retrievePaymentIntentByPaymentId(String paymentId);

	public PaymentMethod attachCustomerToPayment(String paymentId,String customerId);

	public PaymentIntent chargeSavedCards(double amount,String currency,String customerId, String paymentMethodId,String email);

	public boolean detachACardFromCustomer(String stripeUserId,String cardId);

	public PaymentMethod retrievePaymentMethodById(String paymentMethodId);
	
	public Cards getSavedCardListByCustomerId(String customerId);
}
