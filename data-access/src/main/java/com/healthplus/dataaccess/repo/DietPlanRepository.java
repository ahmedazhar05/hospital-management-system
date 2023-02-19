package com.healthplus.dataaccess.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.healthplus.dataaccess.domain.DietPlan;


public interface DietPlanRepository extends JpaRepository<DietPlan,Integer> {
    @Query(value="Select * From dietplan where id=?1 ")
	List<DietPlan> getDietPlanByPrescription(Long id);

}

