package com.healthplus.processmanagement.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.healthplus.processmanagement.model.Appointment;
import com.healthplus.processmanagement.model.Doctor;
import com.healthplus.processmanagement.model.Patient;

public class PatientController {
	// @Value("${jpa.domain}")
	private String DOMAIN = "http://localhost:8080/";
	
	private final String PATIENT_URI = DOMAIN + "patients/";
	private final String APPOINTMENT_URI = DOMAIN + "appointments/";

	private RestTemplate restTemplate = new RestTemplate();
	
	@GetMapping(path = "/patient/appointments", params = { "patient", "date" })
	public List<Map<String, Object>> getAppointmentsByDoctor(@RequestParam("patient") Long id, @RequestParam("date") Date date) {
		List<Map<String, Object>> ap = new ArrayList();
		
		Appointment[] appointments = restTemplate.getForObject(APPOINTMENT_URI + "search?patient=" + id + "&date=" + date, Appointment[].class);
		for (Appointment a : appointments) {
			Patient dr = a.getPatient();
			String patientName = dr.getFirstName() + " " + dr.getLastName();
			String time = a.getTimeslot().valueString();
			
			Map<String, Object> map = new HashMap();
			map.put("name", patientName);
			map.put("time", time);
			map.put("id", a.getId());
			ap.add(map);
		}
		return ap;
	}
}
