package src.main.java.com.healthplus.dataaccess.repo;


public interface ReportRepository extends JpaRepository<Report, Long> {

	@Query(value = "SELECT * FROM Report WHERE Pateint = ?1", nativeQuery = true)
	public Optional<Report> getReportByPatient(Long id);
