package com.healthplus.dataaccess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.healthplus.dataaccess.domain.MedicinePlan;
import com.healthplus.dataaccess.repo.MedicinePlanRepository;

import src.main.java.com.healthplus.dataaccess.controller.ReportRepository;

@Controller
@RequestMapping(path="medicines")
public class MedicinePlanController {
	@Autowired
	private MedicinePlanRepository medicinePlanRepository;
	@GetMapping(path = "/search", params = "prescription")
	public List<MedicinePlan> getMedicinePlanBy(@RequestParam("prescription") Long id) {
	    return medicinePlanRepository.getMedicinePlanByPrescription(id);
	}

}
