package com.healthplus.dataaccess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.healthplus.dataaccess.domain.Bed;
import com.healthplus.dataaccess.repo.BedRepository;

@Controller
@RequestMapping(path = "/bed")
public class BedController {
	@Autowired
	public BedRepository bedRepository;

	@PostMapping(path = "/")
	public @ResponseBody String addNewBed(@RequestParam String room, @RequestParam String type, @RequestParam String facility) {
		Bed bed = new Bed();
		bed.setRoom(room);
		bed.setType(type);
		bed.setFacility(facility);
		return "Alloted";
	}

	@GetMapping(path = "/")
	public List<Bed> listBeds() {
		return bedRepository.findAll();
	}

	@GetMapping(path = "/{id}")
	public List<Bed> getBedBy(@PathVariable("id") Long id) {
		return bedRepository.findAll();
	}

	@GetMapping(path = "/search", params = { "patient" })
	public List<Bed> getBedBy(@RequestParam("patient") Integer id) {
		return bedRepository.getBedByPatient(id);
	}
}
