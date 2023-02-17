package com.healthplus.dataaccess.repo;

import org.springframework.data.repository.CrudRepository;

import com.healthplus.dataaccess.domain.Patient;

public interface PatientRepository extends CrudRepository<Patient, Integer> {

}