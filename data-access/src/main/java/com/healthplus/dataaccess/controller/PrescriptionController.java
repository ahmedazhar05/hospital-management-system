package com.healthplus.dataaccess.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthplus.dataaccess.domain.Prescription;
import com.healthplus.dataaccess.repo.PrescriptionRepository;

@RestController
@RequestMapping(path = "/prescriptions")
public class PrescriptionController {
	@Autowired
    private PrescriptionRepository prescriptionRepository;

    @GetMapping(path = "/{id}")
    public Optional<Prescription> getPrescriptionBy(@PathVariable("id") Long id) {
        return prescriptionRepository.findById(id);
    }

	public List<Prescription> getPrescriptionByPatient(Long id) {
		return prescriptionRepository.getPrescriptionByPatient(id);
	}

	public List<Prescription> getPrescriptionByDoctor(Long id) {
		return prescriptionRepository.getPrescriptionByDoctor(id);
	}

}
