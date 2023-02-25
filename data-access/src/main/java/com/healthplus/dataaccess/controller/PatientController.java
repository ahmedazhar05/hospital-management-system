package com.healthplus.dataaccess.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.healthplus.dataaccess.domain.Appointment;
import com.healthplus.dataaccess.domain.Patient;
import com.healthplus.dataaccess.domain.Prescription;
import com.healthplus.dataaccess.domain.Report;
import com.healthplus.dataaccess.repo.PatientRepository;

@RestController
@RequestMapping(path="/patients")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;
    
    @GetMapping(path="")
    public List<Patient> listPatients(){
        return patientRepository.findAll();
    }
    
    @GetMapping(path="/{id}")
    public Optional<Patient> getPatientBy(@PathVariable("id") Long id){
        return patientRepository.findById(id);
    }
    
    @GetMapping(path="/search", params={"email"})
    public Patient getPatientBy(@RequestParam("email") String email){
        return patientRepository.getPatientByEmail(email);
    }
    
    @GetMapping(path="/search", params={"contact"})
    public Patient getPatientByContact(@RequestParam("contact") String contact){
        return patientRepository.getPatientByContact(contact);
    }
    
    @PostMapping(path="")
    public String addNewPatient(@RequestBody Patient p) {
    	patientRepository.save(p);
    	return "Saved";
    }
    
    @PutMapping(path="/{id}")
    public String updatePatient(@PathVariable("id") Long id, @RequestBody Patient newPatient) {
        newPatient.setId(id);
        patientRepository.save(newPatient);
        return "Updated";
    }
    
    @GetMapping(path="/{id}/appointments")
    public List<Appointment> getAppointmentByPatient(@PathVariable("id") Long id){
        return new AppointmentController().getAppointmentByPatient(id);
    }
    
    @GetMapping(path="/{id}/prescriptions")
    public List<Prescription> getPrescriptionByPatient(@PathVariable("id") Long id){
        return new PrescriptionController().getPrescriptionByPatient(id);
    }
    
    @GetMapping(path="/{id}/reports")
    public List<Report> getReportByPatient(@PathVariable("id") Long id){
        return new ReportController().getReportsByPatient(id);
    }
}
