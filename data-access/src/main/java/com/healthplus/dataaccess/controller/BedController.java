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

import com.healthplus.dataaccess.domain.Bed;
import com.healthplus.dataaccess.domain.Doctor;
import com.healthplus.dataaccess.repo.BedRepository;

@Controller
@RequestMapping(path = "/bed")
public class BedController {
	@Autowired
	public BedRepository bedRepository;

	@PostMapping(path = "/")
	public @ResponseBody String addNewBed(@RequestBody Bed newBed) {
		bedRepository.save(newBed);
		return "Added";
	}

	@GetMapping(path = "/")
	public List<Bed> listBeds() {
		return bedRepository.findAll();
	}

	@GetMapping(path = "/{id}")
	public Optional<Bed> getBedBy(@PathVariable("id") Long id) {
		return bedRepository.findById(id);
	}

	@GetMapping(path = "/search", params = { "patient" })
	public List<Bed> getBedBy1(@RequestParam("patient") Long id) {
		return bedRepository.getBedByPatient(id);
	}
	
	@PutMapping(path="/{id}")
	public @ResponseBody String updateBed(@PathVariable("id") Long id, @RequestBody Bed newBed) {
		newBed.setId(id);
		bedRepository.save(newBed);
		return "Saved";
	}
}
