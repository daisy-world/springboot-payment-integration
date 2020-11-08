package com.app.springbootpaymentintegration.dto;



public class Cards {
	private String cardId ;
	private long expMonth;
	private long expYear;
	private String name ;
	private String brand ;
	private String last4digit ;
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public long getExpMonth() {
		return expMonth;
	}
	public void setExpMonth(long expMonth) {
		this.expMonth = expMonth;
	}
	public long getExpYear() {
		return expYear;
	}
	public void setExpYear(long expYear) {
		this.expYear = expYear;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getLast4digit() {
		return last4digit;
	}
	public void setLast4digit(String last4digit) {
		this.last4digit = last4digit;
	}
	
	
	
	
	
}
