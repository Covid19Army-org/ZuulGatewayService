package com.covid19army.ZuulGatewayService.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.covid19army.ZuulGatewayService.RequestScopedUserContext;
import com.covid19army.ZuulGatewayService.client.UserServiceClient;
import com.covid19army.ZuulGatewayService.dtos.UserResponseDto;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	Logger logger = LoggerFactory.getLogger(JwtUserDetailsService.class);
	
	@Autowired
	private UserServiceClient userDao;
	
	@Autowired
	RequestScopedUserContext userContext;	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var user = userDao.findByUsername(username);
		userContext.setUserdto(user);
		logger.info(user.toString());
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}		
		return new org.springframework.security.core.userdetails.User(Long.toString(user.getMobileNumber()), user.getPassword(),
				new ArrayList<>());
	}	
}