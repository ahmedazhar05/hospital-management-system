package com.healthplus.auth.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class HospitalUser implements UserDetails {

	private Long id;
	private String username;
	private String password;
	private String credential;
	private String hash;
	private String role;
	
	public HospitalUser() {
		super();
	}
	
	public HospitalUser(Long id, String credential, String hash, String role) {
		this.id = id;
		this.credential = this.username = credential;
		this.hash = this.password = hash;
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
		this.username = this.credential = credential;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = this.credential = username;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.password = this.hash = hash;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = this.hash = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "HospitalUser [id=" + id + ", credential=" + credential + ", hash=" + hash + ", role=" + role + "]";
	}
	
	//------------------------------------------------

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
