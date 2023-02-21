package com.healthplus.dataaccess.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.healthplus.dataaccess.domain.Bed;
import com.healthplus.dataaccess.domain.Bed.BED;
import com.healthplus.dataaccess.domain.Bed.FACILITY;
import com.healthplus.dataaccess.domain.Bed.ROOM;
import com.healthplus.dataaccess.domain.Doctor;
import com.healthplus.dataaccess.domain.OccupiedBed;
import com.healthplus.dataaccess.repo.BedRepository;
import com.healthplus.dataaccess.repo.OccupiedBedRepository;

@RestController
@RequestMapping(path = "/beds")
public class BedController {
	@Autowired
	public BedRepository bedRepository;
	@Autowired
    private OccupiedBedRepository occupiedBedRepository;

	@GetMapping(path = "/")
	public List<Bed> listBeds() {
		return bedRepository.findAll();
	}
	
	@GetMapping(path="/{id}")
	public Optional<Bed> getBedBy(@PathVariable("id") Long bed) {
		return bedRepository.findById(bed);
	}

	@PutMapping(path = "/{id}", params = { "availability" })
	public String updateBedAvailability(@PathVariable("availability") Long id, @RequestParam Integer availability) {
		Bed b = new Bed();
		b.setId(id);
		b.setAvailability(availability);
		bedRepository.save(b);
		return "Saved";
	}

	@PutMapping(path = "/{id}")
	public String updateOccupiedBed(@PathVariable("id") Long id, @RequestBody OccupiedBed newBed) {
		newBed.setId(id);
		occupiedBedRepository.save(newBed);
		return "Saved";
	}

	@GetMapping(path = "/search", params = { "patient" })
	public List<Bed> getBedByPatient(@RequestParam("patient") Long id) {
		return bedRepository.getBedByPatient(id);
	}

	@PostMapping(path = "/")
	public String addNewBed(@RequestBody OccupiedBed newBed) {
		occupiedBedRepository.save(newBed);
		return "Added";
	}

	@GetMapping(path = "/search", params = { "room", "bed", "facility" })
	public Bed getBedByFilter(@RequestParam("patient") ROOM room, @RequestParam("patient") BED bed, @RequestParam("patient") FACILITY facility) {
		return bedRepository.getBedByFilter(room, bed, facility);
	}
}
