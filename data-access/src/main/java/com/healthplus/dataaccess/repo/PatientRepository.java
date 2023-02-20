package com.healthplus.dataaccess.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.healthplus.dataaccess.domain.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query(value = "SELECT * FROM patient WHERE email = ?1", nativeQuery = true)
    public Patient getPatientByEmail(String email);

    @Query(value = "SELECT * FROM patient WHERE contact = ?1", nativeQuery = true)
    public Patient getPatientByContact(Long contact);
}
