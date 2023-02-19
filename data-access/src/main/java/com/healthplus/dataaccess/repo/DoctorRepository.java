package com.healthplus.dataaccess.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.healthplus.dataaccess.domain.Doctor;


public interface  DoctorRepository extends     JpaRepository<Doctor, Long> {
    @Query(value="SELECT * FROM doctor WHERE email=?1", nativeQuery=true)
    Optional<Doctor> getDoctorByEmail(String email);

    @Query(value="SELECT * FROM doctor WHERE contact=?1", nativeQuery=true)
    Optional<Doctor> getDoctorByContact(Long contact);
    
    @Query(value="SELECT * FROM doctor WHERE id=?1", nativeQuery=true)
    Optional<Doctor> getDoctorByDepartmentId(Long id);

    @Query(value="SELECT appointments FROM doctor WHERE id=?1", nativeQuery=true)
    Optional<Doctor> getAppointmentByDoctorId(Long id);

    @Query(value="SELECT prescriptions FROM doctor WHERE id=?1", nativeQuery=true)
    Optional<Doctor> getPrescriptionByDoctorId(Long id);
    
    

}
