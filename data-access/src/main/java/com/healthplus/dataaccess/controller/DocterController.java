package com.healthplus.dataaccess.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.healthplus.dataaccess.domain.Doctor;
import com.healthplus.dataaccess.repo.DoctorRepository;


@Controller
@RequestMapping(path="/doctors")
public class DocterController {
@Autowired
private DoctorRepository doctorRepository;

@GetMapping(path="/")
public List<Doctor> listDoctors(){
	return doctorRepository.findAll();
}

@GetMapping(path="/{id}")
public List<Doctor> getDoctortBy(@PathVariable("id") Integer id){
	return doctorRepository.findAll();
}
@GetMapping (path="/search", params= {"email"})
public Optional<Doctor> getDoctorBy(@RequestParam("email") String email){
		return doctorRepository.getDoctorByEmail(email);
}

@GetMapping (path="/search", params= {"contact"})
public Optional<Doctor> getDoctorBy(@RequestParam("contact") Long contact){
		return doctorRepository.getDoctorByContact(contact);
}

@GetMapping (path="/search", params= {"department"})
public Optional<Doctor> getDoctorBy(@RequestParam("departmentId") Integer departmentId){
		return doctorRepository.getDoctorByDepartmentId(contact);
}



}
