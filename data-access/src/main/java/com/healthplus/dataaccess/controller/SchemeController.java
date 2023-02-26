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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.healthplus.dataaccess.domain.Scheme;

import com.healthplus.dataaccess.repo.SchemeRepository;

@CrossOrigin
@RestController
@RequestMapping(path = "/schemes")
public class SchemeController {
	@Autowired
	private SchemeRepository schemeRepository;

	@GetMapping(path = "")
	public List<Scheme> listScheme() {
		return schemeRepository.findAll();
	}

	@GetMapping(path = "/{id}")
	public Optional<Scheme> getSchemeBy(@PathVariable("id") Long id) {
		return schemeRepository.findById(id);
	}
	
	@PostMapping(path = "")
	public String addNewScheme(@RequestBody Scheme r) {
		schemeRepository.save(r);
		return "Saved";
	}

	@DeleteMapping(path = "/{id}")
    public String deleteScheme(@PathVariable("id") Long id) {
		schemeRepository.deleteById(id);
		return "Deleted";
    }
}
