package com.app.springbootpaymentintegration.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.springbootpaymentintegration.model.UserDetails;
import com.app.springbootpaymentintegration.repository.UserDetailsRepository;


@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDetailsRepository userDetailsRepository;
	
	@Autowired
	PaymentService paymentService;
	
	@Override
	public UserDetails addAccount(String firstName,String lastName,String email,String password,String confirmPassword) {
		
		String name = firstName + " " + lastName;
		String customerId= paymentService.createStripeCustomer(email, name);
		/*insert to user details table*/

		UserDetails userDetails = new UserDetails();
		userDetails.setFirst_name(firstName);
		userDetails.setLast_name(lastName);
		userDetails.setEmail(email);
		userDetails.setPassword(password);
		userDetails.setConfirm_password(confirmPassword);
		userDetails.setRole("Admin");
		userDetails.setCreation_date(new Date());
		userDetails.setStripe_customer_id(customerId);
		UserDetails details = userDetailsRepository.save(userDetails);
		return details;

	}

	@Override
	public UserDetails fetchUserDetails(String userId) {

		UserDetails userDetails = userDetailsRepository.findOne(userId);
		
		return userDetails;
	}

	@Override
	public List<UserDetails> getUserList() {
		
		List<UserDetails> userList = userDetailsRepository.findAll();
		return userList;
		
	}

	@Override
	public UserDetails fetchUserByEmail(String email) {

		UserDetails userDetails =userDetailsRepository.getUserDetailsByEmail(email);
		
		return userDetails;
	}

	@Override
	public void updatePassword(String email,String newPassword) {
		UserDetails userDetails =userDetailsRepository.getUserDetailsByEmail(email);
		
		userDetails.setPassword(newPassword);
		userDetails.setConfirm_password(newPassword);
		userDetailsRepository.save(userDetails);
	}

	

	@Override
	public UserDetails addUser(String firstName,String lastName,String email,String password,String confirmPassword) {
		
	
        
		/*insert to user details table*/

		UserDetails userDetails = new UserDetails();
		userDetails.setFirst_name(firstName);
		userDetails.setLast_name(lastName);
		userDetails.setEmail(email);
		userDetails.setPassword(password);
		userDetails.setConfirm_password(confirmPassword);
		userDetails.setRole("User");
		userDetails.setCreation_date(new Date());

		UserDetails details = userDetailsRepository.save(userDetails);
		return details;

	}
	
	

}
