package com.healthplus.dataaccess.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.healthplus.dataaccess.domain.OccupiedBed;

public interface OccupiedBedRepository extends JpaRepository<OccupiedBed, Long> {
	
    @Query(value="SELECT * FROM occupied_bed WHERE patient_id = ?1", nativeQuery=true)
    List<OccupiedBed> getOccupiedBedByPatient(Long id);
    
}
