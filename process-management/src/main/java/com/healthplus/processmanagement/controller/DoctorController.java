package com.healthplus.processmanagement.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.healthplus.processmanagement.model.Appointment;
import com.healthplus.processmanagement.model.Doctor;
import com.healthplus.processmanagement.model.Report;

@RestController
public class DoctorController {
	// @Value("${jpa.domain}")
	private String DOMAIN = "http://localhost:8080/";
	
	private final String DOCTOR_URI = DOMAIN + "doctors/";
	private final String APPOINTMENT_URI = DOMAIN + "appointments/";
	
	private RestTemplate restTemplate = new RestTemplate();

	@GetMapping(path = "/doctor/appointments", params = { "doctor", "date" })
	public List<Map<String, Object>> getAppointmentsByDoctor(@RequestParam("doctor") Long id, @RequestParam("date") String dateSt) {
		System.out.println(APPOINTMENT_URI);
		List<Map<String, Object>> ap = new ArrayList();
		
		Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(dateSt);
		} catch (Exception e) {
			System.out.print("Invalid date: " + dateSt);
			return new ArrayList(0);
		}
		
		Appointment[] appointments = restTemplate.getForObject(APPOINTMENT_URI + "search?doctor=" + id + "&date=" + date, Appointment[].class);
		for (Appointment a : appointments) {
			Doctor dr = a.getDoctor();
			String doctorName = dr.getFirstName() + " " + dr.getLastName();
			String time = a.getTimeslot().valueString();
			
			Map<String, Object> map = new HashMap();
			map.put("name", doctorName);
			map.put("time", time);
			map.put("id", a.getId());
			ap.add(map);
		}
		return ap;
	}
}
