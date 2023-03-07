package com.healthplus.dataaccess.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.healthplus.dataaccess.domain.DietPlan;

public interface DietPlanRepository extends JpaRepository<DietPlan, Long> {
	
	@Query(value = "SELECT * FROM diet_plan WHERE prescription_id = ?1 ", nativeQuery = true)
	List<DietPlan> getDietPlanByPrescription(Long id);

}
