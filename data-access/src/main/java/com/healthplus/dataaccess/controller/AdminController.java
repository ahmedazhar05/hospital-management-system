package com.healthplus.dataaccess.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.healthplus.dataaccess.domain.Admin;
import com.healthplus.dataaccess.repo.AdminRepository;

@RestController
@RequestMapping(path = "/admins")
public class AdminController {
    @Autowired
    public AdminRepository adminRepository;

    @GetMapping(path = "/{id}")
    public Optional<Admin> getAdminById(@PathVariable("id") Long id) {
        return adminRepository.findById(id);
    }

    @GetMapping(path = "/search", params = { "email" })
    public Admin getAdminBy(@RequestParam("email") String email) {
        return adminRepository.getAdminByEmail(email);
    }

    @GetMapping(path = "/search", params = { "contact" })
    public Admin getAdminBy(@RequestParam("contact") Long contact) {
        return adminRepository.getAdminByContact(contact);
    }

    @PostMapping(path = "/")
    public String addNewAdmin(@RequestBody Admin newAdmin) {
        adminRepository.save(newAdmin);
        return "Added";
    }

    @DeleteMapping(path = "/{id}")
    public String deleteAdmin(@PathVariable("id") Long id) {
        adminRepository.deleteById(id);
        return "Deleted";
    }
}
