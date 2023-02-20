package com.healthplus.processmanagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.healthplus.processmanagement.model.Patient;
import com.healthplus.processmanagement.model.Report;

@RestController
public class AppointmentController {
	private final String REPORT_URI = "http://localhost:8080/reports";
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(path = "appointment/getDefaults", params = {"patient"})
	public Map<String, String> getAppointmentDefaults(@RequestParam("patient") Long patient) {
		

		Map <String, String> m = new HashMap();
		List<Report> reports= restTemplate.getForObject(REPORT_URI + "/search?patient=" + patient, Report.class);
		
		for(Report r:reports ) {
			m.put(r.getName(), r.getFileUrl());
		}
		return m;
	}

}
