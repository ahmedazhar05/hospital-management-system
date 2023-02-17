package com.healthplus.dataaccess.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.healthplus.dataaccess.domain.Patient;
import com.healthplus.dataaccess.repo.PatientRepository;

@Controller
@RequestMapping(path="/patient")
public class PatientController {
	private PatientRepository patientRepository;
	
	@GetMapping(path="/")
	public Iterable<Patient> listPatients(){
		return patientRepository.findAll();
	}
}
