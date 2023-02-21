package com.healthplus.dataaccess.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.healthplus.dataaccess.domain.Appointment;

import com.healthplus.dataaccess.repo.AppointmentRepository;

@RestController
@RequestMapping(path = "/appointments")
public class AppointmentController {
    @Autowired
    public AppointmentRepository appointmentRepository;

    @GetMapping(path = "/{id}")
    public Optional<Appointment> getAppointmentBy(@PathVariable("id") Long id) {
        return appointmentRepository.findById(id);
    }

    @GetMapping(path = "/search", params = { "patient" })
    public List<Appointment> getAppointmentByPatient(@RequestParam("patient") Long id) {
        return appointmentRepository.getAppointmentByPatient(id);
    }

    @GetMapping(path = "/search", params = { "doctor" })
    public List<Appointment> getAppointmentByDoctor(@RequestParam("doctor") Long id) {
        return appointmentRepository.getAppointmentByDoctor(id);
    }
    
    @GetMapping(path = "/search", params = { "doctor", "date" })
    public Appointment getAppointmentByDoctorDate(@RequestParam("doctor") Long id, @RequestParam("date") Date date) {
        return appointmentRepository.findByDoctorAndDate(id, date);
    }
    
    @GetMapping(path = "/search", params = { "patient", "date" })
    public Appointment getAppointmentByPatientDate(@RequestParam("patient") Long id, @RequestParam("date") Date date) {
        return appointmentRepository.findByPatientAndDate(id, date);
    }
    
    @PostMapping(path = "")
    public String addAppointment(@RequestBody Appointment newApp) {
        appointmentRepository.save(newApp);
        return "Saved";
    }

    @DeleteMapping(path="/{id}")
    public String deleteAppointment(@PathVariable("id") Long id) {
        appointmentRepository.deleteById(id);
        return "Deleted";
    }
}
