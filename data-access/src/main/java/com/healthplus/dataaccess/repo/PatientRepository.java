package com.healthplus.dataaccess.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.healthplus.dataaccess.domain.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

	@Query(value="SELECT * FROM patient WHERE email = ?1", nativeQuery=true)
	public Optional<Patient> getPatientByEmail(String email);

	@Query(value="SELECT * FROM patient WHERE contact = ?1", nativeQuery=true)
	public Optional<Patient> getPatientByContact(Long contact);
}
