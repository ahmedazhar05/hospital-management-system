package src.main.java.com.healthplus.dataaccess.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.healthplus.dataaccess.domain.Report;

import src.main.java.com.healthplus.dataaccess.repo.ReportRepository;

@Controller
@RequestMapping(path = "/reports")
public class ReportController {
	@Autowired
	private ReportRepository reportRepository;
	@GetMapping(path = "/search", params = "patient")
	public List<Report> getReportsBy(@RequestParam("patient") Long id) {
	return reportRepository.getReportsByPtient(id);
}
	@GetMapping(path = "/{id}")
	public Optional<Report> getReportBy(@PathVariable("id") Long id) {
	return reportRepository.findById(id);
	}
	