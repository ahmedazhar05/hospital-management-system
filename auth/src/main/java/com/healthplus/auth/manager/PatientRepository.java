package com.healthplus.auth.manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.healthplus.auth.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query(value = "SELECT * FROM patient WHERE email = ?1", nativeQuery = true)
    public Patient getPatientByEmail(String email);

    @Query(value = "SELECT * FROM patient WHERE contact = ?1", nativeQuery = true)
    public Patient getPatientByContact(String contact);
}
