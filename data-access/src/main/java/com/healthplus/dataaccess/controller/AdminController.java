package com.healthplus.dataaccess.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.healthplus.dataaccess.domain.Admin;
import com.healthplus.dataaccess.repo.AdminRepository;

@Controller
@RequestMapping(path="/admin")
public class AdminController {
@Autowired
public AdminRepository adminRepository;

@PostMapping(path="/")
public @ResponseBody String addNewAdmin(@RequestParam String hash,@RequestParam String email,@RequestParam String contact) {
  Admin admin=new Admin();
  admin.setHash(hash);
  admin.setEmail(email);
  admin.setContact(contact);
return "Added";
}

@GetMapping(path="/{id}")
public List<Admin> getAdminBy(@PathVariable("id") Integer id){
	return adminRepository.findAll();
}
@GetMapping (path="/search", params= {"email"})
public Optional<Admin> getAdminBy(@RequestParam("email") String email){
		return adminRepository.getAdminByEmail(email);
}

@GetMapping (path="/search", params= {"contact"})
public Optional<Admin> getAdminBy(@RequestParam("contact") Long contact){
		return adminRepository.getAdminByContact(contact);
}


}
