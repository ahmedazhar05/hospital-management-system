package com.healthplus.dataaccess.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.healthplus.dataaccess.domain.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    @Query(value="SELECT * FROM admin WHERE email=?1", nativeQuery=true)
    Optional<Admin> getAdminByEmail(String email);

    @Query(value="SELECT * FROM admin WHERE contact=?1", nativeQuery=true)
    Optional<Admin> getAdminByContact(Long contact);

}
