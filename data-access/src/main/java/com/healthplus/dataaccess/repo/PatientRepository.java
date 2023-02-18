package com.healthplus.dataaccess.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestParam;

import com.healthplus.dataaccess.domain.Patient;

public interface PatientRepository extends CrudRepository<Patient, Integer> {

	@Query("SELECT * FROM Patient WHERE email = ?1")
	public Optional<Patient> getPatientByEmail(String email);

	@Query("SELECT * FROM Patient WHERE contact = ?1")
	public Optional<Patient> getPatientByContact(Long contact);
}
