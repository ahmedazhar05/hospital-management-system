package com.healthplus.dataaccess.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.healthplus.dataaccess.domain.Department;
import com.healthplus.dataaccess.domain.Doctor;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	// @Query("SELECT * FROM doctors WHERE department = ?1")
	// List<Doctor> findDoctorsByDepartment(Long id);

}
