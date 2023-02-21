package com.healthplus.processmanagement.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.healthplus.processmanagement.model.Doctor;
import com.healthplus.processmanagement.model.MedicinePlan;
import com.healthplus.processmanagement.model.Patient;
import com.healthplus.processmanagement.model.Prescription;
import com.healthplus.processmanagement.service.PatientService;

@RestController
public class BillController {

	private final String BILL_URI = "http://localhost:8080/bills";
	private final String PATIENT_URI = "http://localhost:8080/patients";

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private PatientService patientService;

	@GetMapping(path = "bill/getPrescriptions", params = { "credential" })
	public List<Prescription> getPrescriptionDefaults(@RequestParam("credential") String credential) {
		Patient p = patientService.getPatientByCredential(credential);
		if (p == null) {
			// TODO: Create HTTP Response and return
		} else {
			Prescription[] pr = restTemplate.getForObject(PATIENT_URI + "/" + p.getId() + "/prescriptions", Prescription[].class);
			return Arrays.asList(pr);
		}
		return new ArrayList(0);
	}

	private final String MEDICINE_URI = "http://localhost:8080/medicines";
	private final String PRESCRIPTION_URI = "http://localhost:8080/prescriptions";
	private final String DOCTOR_URI = "http://localhost:8080/doctors";

	@GetMapping(path = "/bill/prescription/{id}")
	public Map<String, Integer> getPrescriptionCosts(@PathVariable("id") Long prescription) {
		MedicinePlan[] medicines = restTemplate.getForObject(MEDICINE_URI + "/search?prescription=" + prescription, MedicinePlan[].class);
		int count = medicines.length;
		Integer medTotal = count * 100;

		Prescription pr = restTemplate.getForObject(PRESCRIPTION_URI + "/" + prescription, Prescription.class);

		Doctor dr = restTemplate.getForObject(DOCTOR_URI + "/" + pr.getDoctor(), Doctor.class);
		Integer fee = dr.getFees();
		
		Map<String, Integer> t = new HashMap();
		
		t.put("medicines_cost", medTotal);
		t.put("professional_fees", fee);
		
		return t;
	}

}
