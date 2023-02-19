package com.healthplus.dataaccess.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.healthplus.dataaccess.domain.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query(value = "SELECT * FROM appointment WHERE patient=?1", nativeQuery = true)
    public List<Appointment> getAppointmentByPatient(Integer id);

    @Query(value = "SELECT * FROM appointment WHERE doctor=?1", nativeQuery = true)
    public List<Appointment> getAppointmentByPatient(Long id);

}
