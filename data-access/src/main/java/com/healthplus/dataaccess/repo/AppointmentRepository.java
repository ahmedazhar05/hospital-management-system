package com.healthplus.dataaccess.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.healthplus.dataaccess.domain.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query(value = "SELECT * FROM appointment WHERE patient_id = ?1", nativeQuery = true)
    public List<Appointment> getAppointmentByPatient(Long id);

    @Query(value = "SELECT * FROM appointment WHERE doctor_id = ?1", nativeQuery = true)
    public List<Appointment> getAppointmentByDoctor(Long id);

    @Query(value = "SELECT * FROM appointment WHERE doctor_id = ?1 AND Date(date) = ?2", nativeQuery = true)
	public List<Appointment> findByDoctorAndDate(Long id, String date);

    @Query(value = "SELECT * FROM appointment WHERE patient_id = ?1 AND Date(date) = ?2", nativeQuery = true)
	public List<Appointment> findByPatientAndDate(Long id, String date);

}