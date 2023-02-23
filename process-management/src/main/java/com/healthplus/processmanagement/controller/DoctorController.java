package com.healthplus.processmanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.healthplus.processmanagement.model.Appointment;
import com.healthplus.processmanagement.model.Doctor;
import com.healthplus.processmanagement.model.Report;

@RestController
public class DoctorController {
	private RestTemplate restTemplate = new RestTemplate();
	private final String DOCTOR_URI = "http://localhost:8080/doctors";
	private final String APPOINTMENT_URI = "http://localhost:8080/appointments";
	
	public List<Appointment> getAppointmentsByDoctor(Long id) {
		List<Appointment> ap=new ArrayList();
		
		Doctor d=restTemplate.getForObject(DOCTOR_URI + "/" +id, Doctor.class);
		Appointment[] appointments=restTemplate.getForObject(APPOINTMENT_URI + "/search?doctor=" +d.getId(), Appointment[].class);
		for(Appointment a:appointments) {
			ap.add(a);
		}
		return ap;
	}
}
