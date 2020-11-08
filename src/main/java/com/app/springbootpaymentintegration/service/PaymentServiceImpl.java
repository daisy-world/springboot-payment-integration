package com.app.springbootpaymentintegration.service;

import com.app.springbootpaymentintegration.dto.Cards;
import com.stripe.model.PaymentIntent;
import com.stripe.model.PaymentMethod;

public class PaymentServiceImpl implements PaymentService {

	@Override
	public String createStripeCustomer(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaymentIntent createPaymentIntent(double amount, String currency, String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaymentIntent retrievePaymentIntentByPaymentId(String paymentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaymentMethod attachCustomerToPayment(String paymentId, String customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaymentIntent chargeSavedCards(double amount, String currency, String customerId, String paymentMethodId,
			String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean detachACardFromCustomer(String stripeUserId, String cardId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PaymentMethod retrievePaymentMethodById(String paymentMethodId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cards getSavedCardListByCustomerId(String customerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
