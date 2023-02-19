package com.healthplus.dataaccess.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.healthplus.dataaccess.domain.Patient;
import com.healthplus.dataaccess.repo.DoctorRepository;

@Controller
@RequestMapping(path = "/doctors")
public class DocterController {
	@Autowired
	private DoctorRepository doctorRepository;

	@GetMapping(path = "/")
	public List<Doctor> listDoctors() {
		return doctorRepository.findAll();
	}

	@GetMapping(path = "/{id}")
	public Optional<Doctor> getDoctorBy(@PathVariable("id") Long id) {
		return doctorRepository.findById(id);
	}

	@GetMapping(path = "/search", params = { "email" })
	public Optional<Doctor> getDoctorBy(@RequestParam("email") String email) {
		return doctorRepository.getDoctorByEmail(email);
	}

	@GetMapping(path = "/search", params = { "contact" })
	public Optional<Doctor> getDoctorBy1(@RequestParam("contact") Long contact) {
		return doctorRepository.getDoctorByContact(contact);
	}

	@GetMapping(path = "/search", params = { "department" })
	public Optional<Doctor> getDoctorByDepartment(@RequestParam("department") Long id) {
		return doctorRepository.getDoctorByDepartmentId(id);
	}
	
	@GetMapping(path = "/{id}/appointments", params = { "appointments" })
	public Optional<Doctor> getAppointmentByDoctorId(@RequestParam("appointments") Long id) {
		return doctorRepository.getAppointmentByDoctorId(id);
	}
	
	@GetMapping(path = "/{id}/prescriptions", params = { "prescriptions" })
	public Optional<Doctor> getPrescriptionByDoctorId(@RequestParam("prescriptions") Long id) {
		return doctorRepository.getPrescriptionByDoctorId(id);
	}

	@DeleteMapping(path="/{id}")
	public @ResponseBody String deleteDoctor(@PathVariable("id") Long id) {
		doctorRepository.deleteById(id);
		return "Deleted";
	}
	
	@PutMapping(path="/{id}")
	public @ResponseBody String updateDoctor(@PathVariable("id") Long id, @RequestBody Doctor newDoctor) {
		newDoctor.setId(id);
		doctorRepository.save(newDoctor);
		return "Saved";
	}
	
	@PostMapping(path = "/")
	public @ResponseBody String addNewDoctor(@RequestBody Doctor newDoctor) {
		doctorRepository.save(newDoctor);
		return "Added";
	}
}
