package com.healthplus.dataaccess.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.healthplus.dataaccess.domain.MedicinePlan;

public interface MedicinePlanRepository extends JpaRepository<MedicinePlan, Long> {

	@Query(value = "SELECT * FROM medicinePlan WHERE prescription = ?1", nativeQuery = true)
	 List<MedicinePlan> getMedicinePlanByPrescription(Long id)
}