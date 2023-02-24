package com.healthplus.dataaccess.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.healthplus.dataaccess.domain.User;
import com.healthplus.dataaccess.repo.AdminRepository;
import com.healthplus.dataaccess.repo.DoctorRepository;
import com.healthplus.dataaccess.repo.PatientRepository;

@RestController
@RequestMapping(path = "/users")
public class UserController {

	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private DoctorRepository doctorRepository;

	@GetMapping(path = "/search", params = { "credential" })
	public User getUserById(@RequestParam("credential") String credential) {

		User user;
		
		String role = "patient";
		user = patientRepository.getPatientByEmail(credential);
		if(user != null) {
			user.setRole(role);
			user.setCredential(credential);
			return user;
		}
		user = patientRepository.getPatientByContact(credential);
		if(user != null) {
			user.setRole(role);
			user.setCredential(credential);
			return user;
		}
		role = "doctor";
		user = doctorRepository.getDoctorByEmail(credential);
		if(user != null) {
			user.setRole(role);
			user.setCredential(credential);
			return user;
		}
		user = doctorRepository.getDoctorByContact(credential);
		if(user != null) {
			user.setRole(role);
			user.setCredential(credential);
			return user;
		}
		role = "admin";
		user = adminRepository.getAdminByEmail(credential);
		if(user != null) {
			user.setRole(role);
			return user;
		}
		user = adminRepository.getAdminByContact(credential);
		if(user != null) {
			user.setRole(role);
			user.setCredential(credential);
			return user;
		}
		return user;

	}
}