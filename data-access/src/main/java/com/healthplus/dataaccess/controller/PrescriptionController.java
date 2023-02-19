package com.healthplus.dataaccess.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthplus.dataaccess.domain.Patient;
import com.healthplus.dataaccess.domain.Prescription;
import com.healthplus.dataaccess.repo.PrescriptionRepository;

@RestController
@RequestMapping(path = "/prescription")
public class PrescriptionController {
    private PrescriptionRepository prescriptionRepository;

    @GetMapping(path = "/{id}")
    public Optional<Prescription> getPrescriptionBy(@PathVariable("id") Long id) {
        return prescriptionRepository.findById(id);
    }

}
