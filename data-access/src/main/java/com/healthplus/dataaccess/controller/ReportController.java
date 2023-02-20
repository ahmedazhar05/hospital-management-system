package com.healthplus.dataaccess.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.healthplus.dataaccess.domain.Report;

import com.healthplus.dataaccess.repo.ReportRepository;

@RestController
@RequestMapping(path = "/reports")
public class ReportController {
	@Autowired
	private ReportRepository reportRepository;

	@GetMapping(path = "/search", params = {"patient"})
	public List<Report> getReportsBy(@RequestParam("patient") Long id) {
		return reportRepository.getReportByPatient(id);
	}

	@GetMapping(path = "/{id}")
    public Optional<Report> getReportBy(@PathVariable("id") Long id) {
		return reportRepository.findById(id);
    }
	
	@PostMapping(path = "/")
	public String addNewReport(@RequestBody Report r) {
		reportRepository.save(r);
		return "Saved";
	}

	@DeleteMapping(path = "/{id}")
    public String deleteReport(@PathVariable("id") Long id) {
		reportRepository.deleteById(id);
		return "Deleted";
    }
}