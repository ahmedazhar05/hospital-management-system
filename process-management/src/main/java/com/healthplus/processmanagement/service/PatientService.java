package com.healthplus.processmanagement.service;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.healthplus.processmanagement.model.Patient;

@Service
public class PatientService {

	private final String PATIENT_URI = "http://localhost:8080/patients";
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Patient getPatientByCredential(String credential) {
		Patient p;
		if (Pattern.matches("[A-Za-z0-9_.]+@[A-Za-z]+\\.[A-Za-z]+", credential)) {
			p = restTemplate.getForObject(PATIENT_URI + "/search?email=" + credential, Patient.class);
		} else {
			p = restTemplate.getForObject(PATIENT_URI + "/search?contact=" + credential, Patient.class);
		}
		return p;
	}
}
