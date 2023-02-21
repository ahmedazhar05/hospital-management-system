package com.healthplus.processmanagement.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.healthplus.processmanagement.model.Report;

@Service
public class ReportService {
	@Autowired
	private RestTemplate restTemplate;

	private final String REPORT_URI = "http://localhost:8080/reports";
	
	public List<Map<String, String>> getReportsByPatient(Long id) {
		List<Map<String, String>> m = new ArrayList();
		Report[] reports = restTemplate.getForObject(REPORT_URI + "/search?patient=" + id, Report[].class);

		for (Report r : reports) {
			Map<String, String> obj = new HashMap();
			obj.put("name", r.getName());
			obj.put("url", r.getFileUrl());
			m.add(obj);
		}
		return m;
	}
	
}
