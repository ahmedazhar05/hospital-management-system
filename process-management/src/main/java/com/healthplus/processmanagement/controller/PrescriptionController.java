package com.healthplus.processmanagement.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.healthplus.processmanagement.model.Doctor;
import com.healthplus.processmanagement.model.Patient;
import com.healthplus.processmanagement.util.GenericUtility;

@RestController
public class PrescriptionController {
	// @Value("${jpa.domain}")
	private String DOMAIN = "http://localhost:8080/";
	
	private final String PATIENT_URI = DOMAIN + "patients/";
	private final String DOCTOR_URI = DOMAIN + "doctors/";
	
	private RestTemplate restTemplate = new RestTemplate();
	
	@GetMapping(path = "prescription/getDefaults", params = { "patient", "doctor" })
	public Map<String, Object> getPrescriptionDefaults(@RequestParam("patient") Long patient, @RequestParam("doctor") Long doctor){
		
		Map <String, Object> m = new HashMap();
		Patient p = restTemplate.getForObject(PATIENT_URI + patient, Patient.class);
		
		Date dob = p.getDateOfBirth();
		Date today = new Date();
		int age = today.getYear() - dob.getYear();
		
		m.put("patient_name", p.getFirstName() + " " + p.getLastName());
		m.put("patient_age", age);
		m.put("date", today);
		
		Doctor d = restTemplate.getForObject(DOCTOR_URI + patient, Doctor.class);
		
		m.put("doctor_name", d.getFirstName() + " " + d.getLastName());
		m.put("doctor_degrees", d.getDegrees());
		
		return m;
	}
	
	/*
	@PostMapping(path = "prescription", params = { "doctor" })
	public Map<String, Object> getPrescriptionDefaults(@RequestParam("doctor") Long doctor){
		
		Map <String, Object> m = new HashMap();
		List<Patient> p = restTemplate.getForObject(PATIENT_URI + "/", Patient.class);
		
		
		
		m.put("patient_name", p.getFirstName() + " " + p.getLastName());
		m.put("patient_age", age);
		m.put("date", today);
		
		Doctor d = restTemplate.getForObject(DOCTOR_URI + "/" + patient, Doctor.class);
		
		m.put("doctor_name", d.getFirstName() + " " + d.getLastName());
		m.put("doctor_degrees", d.getDegrees());
		
		return m;
	}
	*/
}
