package com.healthplus.dataaccess.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.healthplus.dataaccess.domain.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	@Query(value = "SELECT * FROM doctor WHERE email = ?1", nativeQuery = true)
	Doctor getDoctorByEmail(String email);

	@Query(value = "SELECT * FROM doctor WHERE contact = ?1", nativeQuery = true)
	Doctor getDoctorByContact(Long contact);

	@Query(value = "SELECT * FROM doctor WHERE department_id = ?1", nativeQuery = true)
	List<Doctor> getDoctorByDepartmentId(Long id);

}
