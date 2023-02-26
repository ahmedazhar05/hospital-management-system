package com.healthplus.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.healthplus.auth.manager.TokenManager;
import com.healthplus.auth.model.HospitalUser;
import com.healthplus.auth.model.JwtRequestModel;
import com.healthplus.auth.model.JwtResponseModel;
import com.healthplus.auth.service.JwtUserDetailsService;

@RestController
@CrossOrigin
public class JwtController {
	
	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenManager tokenManager;

	@PostMapping("/login")
	public ResponseEntity<?> createToken(@RequestBody JwtRequestModel request) throws Exception {
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
		System.out.println(request);
		final HospitalUser userDetails = (HospitalUser) userDetailsService.loadUserByUsername(request.getUsername());
		System.out.println(userDetails);
		final String jwtToken = tokenManager.generateJwtToken(userDetails);
		
		return ResponseEntity.ok(new JwtResponseModel(jwtToken));
	}
}