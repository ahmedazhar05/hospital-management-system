package com.healthplus.auth.model;

import java.util.ArrayList;
import org.springframework.security.core.userdetails.User;

public class HospitalUser2 extends User {

	private Long id;
	private String credential;
	private String hash;
	private String role;
	
	public HospitalUser2(Long id, String credential, String hash, String role) {
		super(credential, hash, new ArrayList<>());
		this.id = id;
		this.credential = credential;
		this.hash = hash;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCredential() {
		return credential;
	}

	public void setCredential(String credential) {
		this.credential = credential;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
