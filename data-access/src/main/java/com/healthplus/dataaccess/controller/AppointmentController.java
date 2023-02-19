package com.healthplus.dataaccess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.healthplus.dataaccess.domain.Appointment;

import com.healthplus.dataaccess.repo.AppointmentRepository;

@Controller
@RequestMapping(path = "/appointments")
public class AppointmentController {
	@Autowired
	public AppointmentRepository appointmentRepository;

	@GetMapping(path = "/{id}")
	public List<Appointment> getAppointmentBy(@PathVariable("id") Long id) {
		return appointmentRepository.findAll();
	}

	@GetMapping(path = "/search", params = { "patient" })
	public List<Appointment> getAppointmentBy(@RequestParam("patient") Integer id) {
		return appointmentRepository.getAppointmentByPatient(id);
	}

	@GetMapping(path = "/search", params = { "doctor" })
	public List<Appointment> getAppointmentBy1(@RequestParam("doctor") Long id) {
		return appointmentRepository.getAppointmentByPatient(id);
	}

	@DeleteMapping(path="/{id}")
	public @ResponseBody String deleteAppointment(@PathVariable("id") Long id) {
		appointmentRepository.deleteById(id);
		return "Deleted";
	}
}
