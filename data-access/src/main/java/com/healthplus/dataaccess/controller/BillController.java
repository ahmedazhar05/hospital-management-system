package com.healthplus.dataaccess.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.healthplus.dataaccess.domain.Bill;
import com.healthplus.dataaccess.domain.Doctor;
import com.healthplus.dataaccess.repo.BillRepository;

@RestController
@RequestMapping(path = "/bills")
public class BillController {
	@Autowired
	private BillRepository billRepository;

	@GetMapping(path = "/{id}")
	public Optional<Bill> getBillBy(@PathVariable("id") Long id) {
		return billRepository.findById(id);
	}

	@GetMapping(path = "/search", params = { "patient" })
	public List<Bill> getBillByPatient(@RequestParam("patient") Long id) {
		return billRepository.getBillByPatient(id);
	}

	@PostMapping(path = "")
	public @ResponseBody String addNewBill(@RequestBody Bill newBill) {
		billRepository.save(newBill);
		return "Added";
	}

}
