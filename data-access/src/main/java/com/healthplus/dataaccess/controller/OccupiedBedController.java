package com.healthplus.dataaccess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.healthplus.dataaccess.domain.OccupiedBed;
import com.healthplus.dataaccess.domain.Patient;
import com.healthplus.dataaccess.repo.OccupiedBedRepository;
import com.healthplus.dataaccess.repo.TimeslotRepository;

@Controller
@RequestMapping(path = "/bed")
public class OccupiedBedController {
    @Autowired
    private OccupiedBedRepository occupiedBedRepository;

    @GetMapping(path = "/")
    public List<OccupiedBed> listOccupiedBeds() {
        return occupiedBedRepository.findAll();
    }

    @GetMapping(path = "/search", params= {"patient"})
    public List<OccupiedBed> getBookedBedsByPatientId(@RequestParam("patient") Long id) {
        return occupiedBedRepository.getOccupiedBedByPatient(id);

    }
}