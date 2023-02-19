package com.healthplus.dataaccess.controller;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.healthplus.dataaccess.domain.Department;
import com.healthplus.dataaccess.repo.DepartmentRepository;

@Controller
@RequestMapping(path="/departments")
public class DepartmentController {
@Autowired
public DepartmentRepository departmentRepository;
@GetMapping(path="/")
public List<Department> listDepartments(){
	return departmentRepository.findAll();
}

@GetMapping(path="/{id}")
public Optional<Department> getDepartmentBy(@PathVariable("id") Integer id){
	return departmentRepository.findById(id);
}
}
