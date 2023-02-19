package com.healthplus.dataaccess.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.healthplus.dataaccess.domain.Bed;

public interface BedRepository extends JpaRepository<Bed,Long> {
	@Query(value="Select * From bed Where patient=?1", nativeQuery=true)
	List<Bed> getBedByPatient(Long id);

	

}
