package com.app.springbootpaymentintegration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.springbootpaymentintegration.model.UserDetails;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, String>{
	
	@Query(value = "select u from UserDetails u where u.email=:emailid" )
	public UserDetails getUserDetailsByEmail(@Param(value="emailid") String email);

}
