package com.healthplus.dataaccess.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.healthplus.dataaccess.domain.Patient;
import com.healthplus.dataaccess.repo.PatientRepository;

@Controller
@RequestMapping(path="/patients")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;
    
    @GetMapping(path="/")
    public List<Patient> listPatients(){
        return patientRepository.findAll();
    }
    
    @GetMapping(path="/{id}")
    public Optional<Patient> getPatientBy(@PathVariable("id") Long id){
        return patientRepository.findById(id);
    }
    
    @GetMapping(path="/search", params={"email"})
    public Optional<Patient> getPatientBy(@RequestParam("email") String email){
        return patientRepository.getPatientByEmail(email);
    }
    
    @GetMapping(path="/search", params={"contact"})
    public Optional<Patient> getPatientByContact(@RequestParam("contact") Long contact){
        return patientRepository.getPatientByContact(contact);
    }
    
    @PutMapping(path="/{id}")
    public @ResponseBody String updatePatient(@PathVariable("id") Long id, @RequestBody Patient newPatient) {
        newPatient.setId(id);
        patientRepository.save(newPatient);
        return "Saved";
    }
}
