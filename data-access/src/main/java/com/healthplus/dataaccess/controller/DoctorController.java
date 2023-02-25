package com.healthplus.dataaccess.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.healthplus.dataaccess.domain.Appointment;
import com.healthplus.dataaccess.domain.Doctor;
import com.healthplus.dataaccess.domain.Prescription;
import com.healthplus.dataaccess.repo.DoctorRepository;

@CrossOrigin
@RestController
@RequestMapping(path = "/doctors")
public class DoctorController {
	@Autowired
	private DoctorRepository doctorRepository;

	@GetMapping(path = "")
	public List<Doctor> listDoctors() {
		return doctorRepository.findAll();
	}

	@GetMapping(path = "/{id}")
	public Optional<Doctor> getDoctorBy(@PathVariable("id") Long id) {
		return doctorRepository.findById(id);
	}

	@GetMapping(path = "/search", params = { "email" })
	public Doctor getDoctorByEmail(@RequestParam("email") String email) {
		return doctorRepository.getDoctorByEmail(email);
	}

	@GetMapping(path = "/search", params = { "contact" })
	public Doctor getDoctorByContact(@RequestParam("contact") String contact) {
		return doctorRepository.getDoctorByContact(contact);
	}

	@GetMapping(path = "/search", params = { "department" })
	public List<Doctor> getDoctorByDepartment(@RequestParam("department") Long id) {
		return doctorRepository.getDoctorByDepartmentId(id);
	}

	@PostMapping(path = "")
	public String addNewDoctor(@RequestBody Doctor newDoctor) {
		doctorRepository.save(newDoctor);
		return "Added";
	}

	@PutMapping(path = "/{id}")
	public String updateDoctor(@PathVariable("id") Long id, @RequestBody Doctor newDoctor) {
		newDoctor.setId(id);
		doctorRepository.save(newDoctor);
		return "Saved";
	}

	@GetMapping(path = "/{id}/appointments")
	public List<Appointment> getAppointmentByDoctorId(@PathVariable("id") Long id) {
		return new AppointmentController().getAppointmentByDoctor(id);
		// return doctorRepository.getAppointmentByDoctorId(id);
	}

	@GetMapping(path = "/{id}/prescriptions")
	public List<Prescription> getPrescriptionByDoctorId(@PathVariable("id") Long id) {
		return new PrescriptionController().getPrescriptionByDoctor(id);
		// return doctorRepository.getPrescriptionByDoctorId(id);
	}

	@DeleteMapping(path = "/{id}")
	public String deleteDoctor(@PathVariable("id") Long id) {
		doctorRepository.deleteById(id);
		return "Deleted";
	}
}
