package com.healthplus.dataaccess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.healthplus.dataaccess.domain.Bill;
import com.healthplus.dataaccess.repo.BillRepository;

@Controller
@RequestMapping(path="/bill")
public class BillController {
@Autowired
private BillRepository billRepository;

@GetMapping(path="/{id}")
public List<Bill> getBillBy(@PathVariable("id") Long id){
	return billRepository.findAll();
}

@GetMapping(path="/search", params= {"patient"})
public List<Bill> getBillBy(@RequestParam("patient") Integer id ){
	return billRepository.getBillByPatient(id);
}


}
