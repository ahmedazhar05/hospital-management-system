package com.healthplus.dataaccess.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.healthplus.dataaccess.domain.Timeslot;

public interface TimeslotRepository extends JpaRepository<Timeslot, Long> {

	@Query(value = "SELECT * FROM timeslot WHERE doctor = ?1", nativeQuery = true)
	List<Timeslot> getTimeslotByDoctor(Long id);

	@Query(value = "SELECT * FROM timeslot WHERE doctor = ?1 AND date = ?2", nativeQuery = true)
	List<Timeslot> getTimeslotsByDoctorAndDate(Long Id, String date);

}