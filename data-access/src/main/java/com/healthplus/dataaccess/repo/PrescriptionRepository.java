package com.healthplus.dataaccess.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthplus.dataaccess.domain.Prescription;
import com.healthplus.dataaccess.domain.Timeslot;

public interface PrescriptionRepository extends JpaRepository<Prescription, Integer> {

}
