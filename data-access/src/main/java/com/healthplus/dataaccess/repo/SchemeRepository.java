package src.main.java.com.healthplus.dataaccess.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthplus.dataaccess.domain.Scheme;

public interface SchemeRepository extends JpaRepository<Scheme, Long> {

	