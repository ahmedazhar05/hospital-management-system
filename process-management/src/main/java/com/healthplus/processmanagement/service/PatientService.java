package com.healthplus.processmanagement.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.healthplus.processmanagement.model.Patient;

@Service
public class PatientService {

	private final String PATIENT_URI = "http://localhost:8080/patients";
	
	private RestTemplate restTemplate = new RestTemplate();
	
	public Patient getPatientByCredential(String credential) {
		Patient p;
		if (credential.contains("@")) {
			p = restTemplate.getForObject(PATIENT_URI + "/search?email=" + credential, Patient.class);
		} else {
			p = restTemplate.getForObject(PATIENT_URI + "/search?contact=" + credential, Patient.class);
		}
		return p;
	}
}
