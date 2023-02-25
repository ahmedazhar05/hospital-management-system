package com.healthplus.dataaccess.controller;

import java.util.Date;
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
import org.springframework.web.bind.annotation.CrossOrigin;

import com.healthplus.dataaccess.domain.Bed;
import com.healthplus.dataaccess.domain.Bed.BED;
import com.healthplus.dataaccess.domain.Bed.FACILITY;
import com.healthplus.dataaccess.domain.Bed.ROOM;
import com.healthplus.dataaccess.domain.Doctor;
import com.healthplus.dataaccess.domain.OccupiedBed;
import com.healthplus.dataaccess.repo.BedRepository;
import com.healthplus.dataaccess.repo.OccupiedBedRepository;

@CrossOrigin
@RestController
@RequestMapping(path = "/beds")
public class BedController {
	@Autowired
	public BedRepository bedRepository;
	@Autowired
    private OccupiedBedRepository occupiedBedRepository;

	@GetMapping(path = "")
	public List<Bed> listBeds() {
		return bedRepository.findAll();
	}
	
	@GetMapping(path="/{id}")
	public Optional<Bed> getBedBy(@PathVariable("id") Long bed) {
		return bedRepository.findById(bed);
	}

	@PutMapping(path = "/{id}", params = { "availability" })
	public String updateBedAvailability(@PathVariable("availability") Long id, @RequestParam Integer availability) {
		Bed b = bedRepository.getReferenceById(id);
		b.setAvailability(availability);
		bedRepository.save(b);
		return "Saved";
	}

	@PutMapping(path = "/{id}", params = { "endDate" })
	public String updateOccupiedBed(@PathVariable("id") Long id, @RequestParam("endDate") String date) {
		OccupiedBed ob = occupiedBedRepository.getReferenceById(id);
		ob.setEndTime(new Date(date));
		occupiedBedRepository.save(ob);
		return "Saved";
	}

	@GetMapping(path = "/search", params = { "patient" })
	public List<OccupiedBed> getBedByPatient(@RequestParam("patient") Long id) {
		return occupiedBedRepository.getOccupiedBedByPatient(id);
	}

	@PostMapping(path = "")
	public String addNewBed(@RequestBody OccupiedBed newBed) {
		occupiedBedRepository.save(newBed);
		return "Added";
	}

	@GetMapping(path = "/search", params = { "room", "bed", "facility" })
	public Bed getBedByFilter(@RequestParam("patient") ROOM room, @RequestParam("patient") BED bed, @RequestParam("patient") FACILITY facility) {
		return bedRepository.filterBedBy(room, bed, facility);
	}
}
