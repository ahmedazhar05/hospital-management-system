package com.healthplus.processmanagement.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

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

@RestController
public class BillController {

	private final String BILL_URI = "http://localhost:8080/bills";
	private final String PATIENT_URI = "http://localhost:8080/patients";

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping(path = "bill/getPrescriptions", params = { "credential" })
	public List<Prescription> getPrescriptionDefaults(@RequestParam("credential") String credential) {
		Patient p;
		if (Pattern.matches("[A-Za-z0-9_.]+@[A-Za-z]+\\.[A-Za-z]+", credential)) {
			p = restTemplate.getForObject(PATIENT_URI + "/search?email=" + credential, Patient.class);
		}

		else {
			p = restTemplate.getForObject(PATIENT_URI + "/search?contact=" + credential, Patient.class);
		}

		if (p == null) {
			// TODO: Create HTTP Response and return
		}

		else {
			List<Prescription> pr = restTemplate.getForObject(PATIENT_URI + "/" + p.getId() + "/prescriptions",
					Prescription.class);
			return pr;
		}
		return new ArrayList(0);
	}
	
	
	private final String MEDICINE_URI = "http://localhost:8080/medicines";
	private final String PRESCRIPTION_URI = "http://localhost:8080/prescriptions";
	private final String DOCTOR_URI = "http://localhost:8080/doctors";
	@GetMapping(path = "/bill/prescription/{id}")
	
	public Map<String, Integer> getPrescription(@PathVariable("id") Long prescription){
		/*    Output:    {        "medicines_cost" : 123        "professional_fees": 213    }    */
		List<MedicinePlan> medicines;
		
		medicines=restTemplate.getForObject(MEDICINE_URI + "/search?prescription=" + prescription, MedicinePlan.class);
		
		int count=medicines.size();
		
		 int medTotal=count*100;
		 
		 Prescription pr;
		 pr=restTemplate.getForObject(PRESCRIPTION_URI + "/" + prescription, Prescrption.class);
		 
		 Doctor dr;
		 dr=restTemplate.getForObject(DOCTOR_URI + "/" + pr.getDoctor(), Doctor.class);
		 int fee=dr.getFees();
		 Map <String, Object> t = new HashMap();
		 t.put("Medicines",count );
		 t.put("Professional fees",fee );
		 }
	
	
	
	

}
