package com.healthplus.processmanagement.controller;

import java.util.ArrayList;
import java.util.Arrays;
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

import com.healthplus.processmanagement.model.Bed;
import com.healthplus.processmanagement.model.Doctor;
import com.healthplus.processmanagement.model.MedicinePlan;
import com.healthplus.processmanagement.model.OccupiedBed;
import com.healthplus.processmanagement.model.Patient;
import com.healthplus.processmanagement.model.Prescription;
import com.healthplus.processmanagement.service.PatientService;
import com.healthplus.processmanagement.util.GenericUtility;

@RestController
public class BillController {

	private final String BILL_URI = "http://localhost:8080/bills";
	private final String PATIENT_URI = "http://localhost:8080/patients";
	private final String BED_URI = "http://localhost:8080/beds";

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private PatientService patientService;

	@GetMapping(path = "bill/getPrescriptions", params = { "credential" })
	public Map<String, List> getPrescriptionDefaults(@RequestParam("credential") String credential) {
		Patient patient = patientService.getPatientByCredential(credential);
		if (patient == null) {
			// TODO: Create HTTP Response and return
			return new HashMap(0);
		}
		
		Prescription[] pr = restTemplate.getForObject(PATIENT_URI + "/" + patient.getId() + "/prescriptions", Prescription[].class);
		
		List<Map<String, Object>> plist = new ArrayList();
		for(Prescription pres: pr) {
			Map<String, Object> prescription = new HashMap();
			prescription.put("id", pres.getId());
			prescription.put("name", "P#" + pres.getId());
			plist.add(prescription);
		}
		
		OccupiedBed[] occupiedBed = restTemplate.getForObject(BED_URI + "/search?patient=" + patient.getId(), OccupiedBed[].class);
		List<Map<String, Object>> oblist = new ArrayList();
		for(OccupiedBed o: occupiedBed) {
			Map<String, Object> bedmap = new HashMap();
			Bed bed = o.getBed();
			
			// calculating bed type
			String name = bed.getFacility() + " " + bed.getRoom() + " room with " + bed.getType() + " Bed";
			bedmap.put("name", name);
			
			// calculating cost
			Date start = o.getStartTime();
			Integer daysCount = (int) GenericUtility.getDaysBetween(start, new Date());
			Integer cost = daysCount * o.getRate();
			bedmap.put("charge", cost);
			
			oblist.add(bedmap);
		}
		
		Map<String, List> data = new HashMap();
		data.put("prescriptions", plist);
		data.put("occupied_beds", oblist);
		
		return data;
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
