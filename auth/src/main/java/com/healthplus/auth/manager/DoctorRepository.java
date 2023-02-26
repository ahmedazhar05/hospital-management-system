package com.healthplus.auth.manager;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.healthplus.auth.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	@Query(value = "SELECT * FROM doctor WHERE email = ?1", nativeQuery = true)
	Doctor getDoctorByEmail(String email);

	@Query(value = "SELECT * FROM doctor WHERE contact = ?1", nativeQuery = true)
	Doctor getDoctorByContact(String contact);

}
