package com.healthplus.dataaccess.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.healthplus.dataaccess.domain.Bed;
import com.healthplus.dataaccess.domain.Bed.BED;
import com.healthplus.dataaccess.domain.Bed.FACILITY;
import com.healthplus.dataaccess.domain.Bed.ROOM;

public interface BedRepository extends JpaRepository<Bed, Long> {

	@Query(value = "SELECT * FROM occupied_bed WHERE patient_id = ?1", nativeQuery = true)
	List<Bed> getBedByPatient(Long id);

	@Query(value = "SELECT * FROM bed WHERE room = ?1 AND type = ?2 AND facility = ?3", nativeQuery = true)
	Bed getBedByFilter(ROOM room, BED bed, FACILITY facility);

}
