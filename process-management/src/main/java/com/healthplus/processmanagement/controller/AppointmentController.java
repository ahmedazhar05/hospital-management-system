package com.healthplus.processmanagement.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.healthplus.processmanagement.model.Appointment;
import com.healthplus.processmanagement.model.Patient;
import com.healthplus.processmanagement.service.ReportService;
import com.healthplus.processmanagement.util.GenericUtility;

@RestController
public class AppointmentController {
	private final String APPOINTMENT_URI = "http://localhost:8080/appointments";
	private final String PATIENT_URI = "http://localhost:8080/patients";
	
	private RestTemplate restTemplate = new RestTemplate();
	
	@Autowired
	private ReportService reportService;

	@GetMapping(path = "appointment/getDefaults", params = { "patient" })
	public List<Map<String, String>> getAppointmentDefaults(@RequestParam("patient") Long patient) {
		return reportService.getReportsByPatient(patient);
	}

	@GetMapping(path = "appointment/schedule/{id}")
	public Map<String, Object> getScheduleDefaults(@PathVariable("id") Long appointment) {
		Appointment a = restTemplate.getForObject(APPOINTMENT_URI + "/" + appointment, Appointment.class);
		Patient p = restTemplate.getForObject(PATIENT_URI + "/" + a.getPatient(), Patient.class);
		List<Map<String, String>> r = reportService.getReportsByPatient(p.getId());
		
		Integer age = (int) GenericUtility.getYearsBetween(p.getDateOfBirth(), new Date());

		Map<String, Object> map = new HashMap();
		map.put("firstname", p.getFirstName());
		map.put("lastname", p.getLastName());
		map.put("age", age);
		map.put("gender", p.getGender());
		map.put("blood_group", p.getBloodGroup());
		map.put("symptoms", a.getSymptom());
		map.put("contact", p.getContact());
		map.put("reports", r);
		
		return map;
	}

}
