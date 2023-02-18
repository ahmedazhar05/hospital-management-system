package com.healthplus.dataaccess.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.healthplus.dataaccess.domain.Patient;
import com.healthplus.dataaccess.repo.PatientRepository;

@Controller
@RequestMapping(path="/patient")
public class PatientController {
	@Autowired
	private PatientRepository patientRepository;
	
	@GetMapping(path="/")
	public Iterable<Patient> listPatients(){
		return patientRepository.findAll();
	}
	
	@GetMapping(path="/get")
	public Optional<Patient> getPatientBy(@RequestParam("id") Integer id) {
		return patientRepository.findById(id);
	}
	
	@GetMapping(path="/get")
	public Optional<Patient> getPatientBy(@RequestParam("email") String email){
		return patientRepository.getPatientByEmail(email);
	}
	
	@GetMapping(path="/get")
	public Optional<Patient> getPatientBy(@RequestParam("contact") Long contact){
		return patientRepository.getPatientByContact(contact);
	}
}
