package com.healthplus.dataaccess.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.healthplus.dataaccess.domain.OccupiedBed;
import com.healthplus.dataaccess.domain.Timeslot;

public interface OccupiedBedRepository extends JpaRepository<OccupiedBed, Long> {
	@Query(value="Select * From OccupiedBed Where patient=?1", nativeQuery=true)
	List<OccupiedBed> getOccupiedBedByPatient(Long id);



}
