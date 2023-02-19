package src.main.java.com.healthplus.dataaccess.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthplus.dataaccess.domain.Report;

public interface ReportRepository extends JpaRepository<Report, Long> {

	@Query(value = "SELECT * FROM Report WHERE Pateint = ?1", nativeQuery = true)
	public Optional<Report> getReportByPatient(Long id);
