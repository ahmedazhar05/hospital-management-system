package com.healthplus.dataaccess.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.healthplus.dataaccess.domain.Timeslot;
import com.healthplus.dataaccess.repo.TimeslotRepository;

@CrossOrigin
@RestController
@RequestMapping(path = "/timeslots")
public class TimeslotController {
	@Autowired
	private TimeslotRepository timeslotRepository;

	@GetMapping(path = "/search", params = { "doctor" })
	public List<Timeslot> getTimeslotbyDoctor(@RequestParam("doctor") Long id) {
		return timeslotRepository.getTimeslotByDoctor(id);
	}

	@GetMapping(path = "/search", params = { "doctor", "date" })
	public List<Timeslot> getTimeslotByDoctorDate(@RequestParam("doctor") Long doctorId, @RequestParam("date") String date) {
		Date d;
		try {
			d = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException pe) {
			System.out.print("Cannot convert into date");
			return new ArrayList(0);
		}
		String days[] = { "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY" };
		return timeslotRepository.getTimeslotByDoctorDay(doctorId, days[d.getDay()]);
	}

	@PostMapping(path = "")
	public String addNewTimeslot(@RequestBody Timeslot ts) {
		timeslotRepository.save(ts);
		return "Saved";
	}

	@DeleteMapping(path = "/{id}")
	public String deleteTimeslot(@PathVariable("id") Long id) {
		timeslotRepository.deleteById(id);
		return "Deleted";
	}
}
