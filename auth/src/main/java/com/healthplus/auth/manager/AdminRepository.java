package com.healthplus.auth.manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.healthplus.auth.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    @Query(value = "SELECT * FROM admin WHERE email = ?1", nativeQuery = true)
    Admin getAdminByEmail(String email);

    @Query(value = "SELECT * FROM admin WHERE contact = ?1", nativeQuery = true)
    Admin getAdminByContact(String contact);
}
