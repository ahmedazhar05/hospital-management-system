package com.healthplus.dataaccess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.healthplus.dataaccess.domain.DietPlan;
import com.healthplus.dataaccess.repo.DietPlanRepository;

@CrossOrigin
@RestController
@RequestMapping(path = "/diet")
public class DietPlanController {
	@Autowired
	public DietPlanRepository dietPlanRepository;

	@GetMapping(path = "/search", params = { "prescription" })
	public List<DietPlan> getDietPlanByPrescription(@RequestParam("prescription") Long id) {
		return dietPlanRepository.getDietPlanByPrescription(id);
	}

	@PostMapping(path = "")
	public @ResponseBody String addNewDiet(@RequestBody DietPlan newDietPlan) {
		dietPlanRepository.save(newDietPlan);
		return "Added";
	}
}
