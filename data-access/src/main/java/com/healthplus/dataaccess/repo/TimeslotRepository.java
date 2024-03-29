package com.healthplus.dataaccess.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.healthplus.dataaccess.domain.Timeslot;

public interface TimeslotRepository extends JpaRepository<Timeslot, Long> {

    @Query(value = "SELECT * FROM timeslot WHERE doctor_id = ?1", nativeQuery = true)
    List<Timeslot> getTimeslotByDoctor(Long id);

    @Query(value = "SELECT * FROM timeslot WHERE doctor_id = ?1 AND dayOfWeek = ?2", nativeQuery = true)
    List<Timeslot> getTimeslotByDoctorDay(Long Id, String date);

}