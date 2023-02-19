package com.healthplus.dataaccess.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.healthplus.dataaccess.domain.Patient;
import com.healthplus.dataaccess.domain.Prescription;
import com.healthplus.dataaccess.repo.PrescriptionRepository;

@Controller
@RequestMapping(path="/prescription")
public class PrescriptionController {
	private PrescriptionRepository prescriptionRepository;
	@GetMapping(path = "/{id}")
	public List<Prescription> getPatientBy(@PathVariable("id") Integer id){
		return patientRepository.findAll();
	}


}
