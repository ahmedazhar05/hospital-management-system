package com.healthplus.auth.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.healthplus.auth.model.HospitalUser;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	private RestTemplate restTemplate = new RestTemplate();
	
	private final String URI = "http://localhost:8080/users/search";

	@Override
	public UserDetails loadUserByUsername(String credential) throws UsernameNotFoundException {
		System.out.println("JwtUserDetailsService::loadUserByUsername()");
		
		if ("randomuser123".equals(credential)) { 
	         return new User("randomuser123", 
	            "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6", 
	            new ArrayList<>()); 
	      } else { 
	         throw new UsernameNotFoundException("User not found with username: " + credential); 
	      } 
		
		/*
		HospitalUser user = restTemplate.getForObject(this.URI + "?credential=" + credential, HospitalUser.class);
		System.out.println("HOSPITAL_USER: " + user);
		if(user == null) {
			throw new UsernameNotFoundException("User not found with credential: " + credential);
		}
		return user;
		/*
		if (user.getCredential().equals(credential)) {
			return user;
		} else {
			throw new UsernameNotFoundException("User not found with credential: " + credential);
		}
		*/
	}
}