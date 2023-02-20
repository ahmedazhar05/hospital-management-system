package com.healthplus.processmanagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.healthplus.dataaccess.domain.Appointment;
import com.healthplus.processmanagement.model.Patient;
import com.healthplus.processmanagement.model.Report;

@RestController
public class AppointmentController {
	private final String REPORT_URI = "http://localhost:8080/reports";
	private final String APPOINTMENT_URI = "http://localhost:8080/appointments";
	private final String PATIENT_URI = "http://localhost:8080/patients";
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
	
/*	@PostMapping(path = "/")
    public @ResponseBody String addNewAppointment(@RequestBody Appointment newAppointment) {
        appointmentRepository.save(newAppointment);
        return "Added";
    } */
	
	
	@GetMapping(path="appointment/schedule/{id}")
	public Map<String, Object> getScheduleDefaults(@PathVariable("id") Long appointment){
	
		com.healthplus.processmanagement.model.Appointment a;
		a=restTemplate.getForObject(APPOINTMENT_URI+"/"+appointment,Appointment.class);
		
		Patient p;
		p=restTemplate.getForObject(PATIENT_URI+"/"+a.getPatient(),Patient.class);
		
		Report r;
		r=restTemplate.getForObject(REPORT_URI+"/search?patient="+p.getId(),Report.class);
		
	}
	

}
