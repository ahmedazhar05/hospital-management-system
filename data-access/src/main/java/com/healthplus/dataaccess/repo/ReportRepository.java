package com.healthplus.dataaccess.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.healthplus.dataaccess.domain.Report;

public interface ReportRepository extends JpaRepository<Report, Long> {

    @Query(value = "SELECT * FROM report WHERE patient_id = ?1", nativeQuery = true)
    public List<Report> getReportByPatient(Long id);
    
}