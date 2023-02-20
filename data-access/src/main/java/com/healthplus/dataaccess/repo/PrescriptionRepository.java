package com.healthplus.dataaccess.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.healthplus.dataaccess.domain.Prescription;
import com.healthplus.dataaccess.domain.Timeslot;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

	@Query(value = "SELECT * FROM prescription WHERE patient = ?1", nativeQuery = true)
	List<Prescription> getPrescriptionByPatient(Long id);

	@Query(value = "SELECT * FROM prescription WHERE doctor = ?1", nativeQuery = true)
	List<Prescription> getPrescriptionByDoctor(Long id);

}
