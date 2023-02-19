package com.healthplus.dataaccess.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.healthplus.dataaccess.domain.Doctor;


public interface  DoctorRepository extends 	JpaRepository<Doctor, Long> {
    @Query(value="Select * From doctor Where email=?1", nativeQuery=true)
	Optional<Doctor> getDoctorByEmail(String email);

    @Query(value="Select * From doctor Where contact=?1", nativeQuery=true)
	Optional<Doctor> getDoctorByContact(Long contact);
    
    @Query(value="Select * From doctor Where id=?1", nativeQuery=true)
	Optional<Doctor> getDoctorByDepartmentId(Long id);

    @Query(value="Select appointments From doctor Where id=?1", nativeQuery=true)
	Optional<Doctor> getAppointmentByDoctorId(Long id);

    @Query(value="Select prescriptions From doctor Where id=?1", nativeQuery=true)
	Optional<Doctor> getPrescriptionByDoctorId(Long id);
    
    

}
