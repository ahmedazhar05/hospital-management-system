package com.healthplus.dataaccess.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthplus.dataaccess.domain.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
