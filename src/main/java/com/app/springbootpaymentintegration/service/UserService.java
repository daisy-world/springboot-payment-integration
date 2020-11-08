package com.app.springbootpaymentintegration.service;

import java.util.List;

import com.app.springbootpaymentintegration.model.UserDetails;


public interface UserService {
	
	public UserDetails addAccount(String firstName,String lastName,String email,String password,String confirmPassword);
	
	public UserDetails fetchUserDetails(String userId);
	
	public List<UserDetails> getUserList();
		
	public UserDetails fetchUserByEmail(String email);

	public void updatePassword(String email,String newPassword);
	
	public UserDetails addUser(String firstName,String lastName,String email,String password,String confirmPassword);


}
