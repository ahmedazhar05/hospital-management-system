package com.healthplus.dataaccess.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.healthplus.dataaccess.domain.Doctor;
import com.healthplus.dataaccess.domain.Timeslot;
import com.healthplus.dataaccess.repo.TimeslotRepository;

@Controller
@RequestMapping(path="/timeslots")
public class TimeslotController {
@Autowired
private TimeslotRepository timeslotRepository;
@GetMapping (path="/search", params= {"doctor"})
public List<Timeslot> getTimeslotby(@RequestParam("doctor") Long id){
		return timeslotRepository.getTimeslotByDoctor(id);
}
@GetMapping(path = "/search", params = {"doctor", "date"})
public List<Timeslot> getTimeslotsByDoctorAndDate(@RequestParam("doctor") Long doctorId, @RequestParam("date") String date) {
    return timeslotRepository.getTimeslotsByDoctorAndDate(doctorId, date);
}
@PostMapping(path = "/")


	
}
