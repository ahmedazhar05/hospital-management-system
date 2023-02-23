package com.healthplus.processmanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.healthplus.processmanagement.model.Appointment;
import com.healthplus.processmanagement.model.Patient;

public class PatientController {

	private RestTemplate restTemplate = new RestTemplate();
	private final String PATIENT_URI = "http://localhost:8080/patients";
	private final String APPOINTMENT_URI = "http://localhost:8080/appointments";
	
	public List<Appointment> getAppointmentsByPatient(Long id) {
		List<Appointment> ap=new ArrayList();
		
		Patient p=restTemplate.getForObject(PATIENT_URI + "/" +id, Patient.class);
		Appointment[] appointments=restTemplate.getForObject(APPOINTMENT_URI + "/search?doctor=" +p.getId(), Appointment[].class);
		for(Appointment a:appointments) {
			ap.add(a);
		}
		return ap;
	}
}
