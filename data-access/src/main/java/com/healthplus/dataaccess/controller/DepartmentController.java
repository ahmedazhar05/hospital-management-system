package com.healthplus.dataaccess.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthplus.dataaccess.domain.Department;
import com.healthplus.dataaccess.domain.Doctor;
import com.healthplus.dataaccess.repo.DepartmentRepository;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {
	@Autowired
	public DepartmentRepository departmentRepository;

	@GetMapping(path = "/")
	public List<Department> listDepartments() {
		return departmentRepository.findAll();
	}

	@GetMapping(path = "/{id}/doctors")
	public List<Doctor> getDoctorsByDepartment(@PathVariable("id") Long id) {
		return new DoctorController().getDoctorByDepartment(id);
		// return departmentRepository.findDoctorsByDepartment(id);
	}
}
