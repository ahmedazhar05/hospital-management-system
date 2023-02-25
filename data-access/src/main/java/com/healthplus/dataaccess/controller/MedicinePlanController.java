package com.healthplus.dataaccess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.healthplus.dataaccess.domain.MedicinePlan;
import com.healthplus.dataaccess.repo.MedicinePlanRepository;

@CrossOrigin
@RestController
@RequestMapping(path = "/medicines")
public class MedicinePlanController {
	@Autowired
	private MedicinePlanRepository medicinePlanRepository;

	@GetMapping(path = "/search", params = { "prescription" })
	public List<MedicinePlan> getMedicinePlanBy(@RequestParam("prescription") Long id) {
		return medicinePlanRepository.getMedicinePlanByPrescription(id);
	}

	@PostMapping(path = "")
	public String addNewMedicinePlan(@RequestBody MedicinePlan mp) {
		medicinePlanRepository.save(mp);
		return "Saved";
	}
}
