package com.healthplus.dataaccess;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.healthplus.dataaccess.domain.Admin;
import com.healthplus.dataaccess.domain.Patient;
import com.healthplus.dataaccess.domain.Report;
import com.healthplus.dataaccess.repo.AdminRepository;
import com.healthplus.dataaccess.repo.PatientRepository;
import com.healthplus.dataaccess.repo.ReportRepository;

@SpringBootTest
class DataAccessApplicationTests {
	
	@Autowired 
	private AdminRepository adminRepository;
	
	@Autowired 
	private ReportRepository reportRepository;
	
	@Autowired
	private PatientRepository patientRepository;

	//Admin
	
	void addNewAdmin() {
		Admin admin=new Admin("kuberkanade","sailila80@gmail.com","9887056435");
		Admin saved=adminRepository.save(admin);
		assertNotNull(saved);
		}
	
	@Test
	void getAdminByEmail() {
		String s="kuberkanade85@gmail.com";
		Admin mail=adminRepository.getAdminByEmail(s);
		assertThat(mail.getEmail()).isEqualTo(s);
	}
	
	@Test
	void getAdminByContact() {
		String s="9970215181";
		Admin contact=adminRepository.getAdminByContact(s);
		assertThat(contact.getContact()).isEqualTo(s);
	}

	@Test
	void getAdminById() {
	long id=152;
	Optional<Admin> identity=adminRepository.findById(id);
	assertThat(identity.get()).isEqualTo(id);
	
	}
	
	@Test
	void deleteAdmin() {
		long id=55;
		Admin delete=adminRepository.deleteById(id);
		adminRepository.save(delete);
		assertNotNull(delete);
	}
	
	//REPORTS 
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	void getReportByPatient() {
		long id=2;
		List<Report> report=reportRepository.getReportByPatient(id);
		assertThat(report.contains(report)).isEqualTo(report);
		}
	@Test
	void addNewReport() {
		Report report=new Report();
		Report saved=reportRepository.save(report);
		assertNotNull(saved);
		}
	
	//Patients
	
	@Test
	void listPatients() {
	List<Patient> list=patientRepository.findAll();
	assertThat(list.contains(list));
	}
	
	@Test
	void getPatientByEmail() {
		String s="kuberkanade@yahoomail.com";
		Patient mail=patientRepository.getPatientByEmail(s);
		assertThat(mail.getEmail()).isEqualTo(s);
	}
	
	@Test
	void getPatientByContact() {
		String s="9028280142";
		Patient contact=patientRepository.getPatientByContact(s);
		assertThat(contact.getContact()).isEqualTo(s);
	}
}
