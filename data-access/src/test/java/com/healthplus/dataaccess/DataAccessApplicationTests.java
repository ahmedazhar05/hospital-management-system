package com.healthplus.dataaccess;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.healthplus.dataaccess.controller.AppointmentController;
import com.healthplus.dataaccess.controller.PrescriptionController;
import com.healthplus.dataaccess.domain.Admin;
import com.healthplus.dataaccess.domain.Appointment;
import com.healthplus.dataaccess.domain.Bed;
import com.healthplus.dataaccess.domain.Bill;
import com.healthplus.dataaccess.domain.Department;
import com.healthplus.dataaccess.domain.Doctor;
import com.healthplus.dataaccess.domain.Patient;
import com.healthplus.dataaccess.domain.Prescription;
import com.healthplus.dataaccess.domain.Report;
import com.healthplus.dataaccess.repo.AdminRepository;
import com.healthplus.dataaccess.repo.AppointmentRepository;
import com.healthplus.dataaccess.repo.BedRepository;
import com.healthplus.dataaccess.repo.BillRepository;
import com.healthplus.dataaccess.repo.DoctorRepository;
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

	@Autowired
	private BedRepository bedRepository;

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private BillRepository billRepository;

	@Autowired
	private DoctorRepository doctorRepository;

	@Autowired
	private AppointmentController appointmentController;

	@Autowired
	private PrescriptionController prescriptionController;

	// Admin
	@Test
	void addNewAdmin() {
		Admin admin = new Admin("kuberkanade", "sailila80@gmail.com", "9887056435");
		Admin saved = adminRepository.save(admin);
		assertNotNull(saved);
	}

	@Test
	void getAdminByEmail() {
		String s = "kuberkanade85@gmail.com";
		Admin mail = adminRepository.getAdminByEmail(s);
		assertThat(mail.getEmail()).isEqualTo(s);
	}

	@Test
	void getAdminByContact() {
		String s = "9970215181";
		Admin contact = adminRepository.getAdminByContact(s);
		assertThat(contact.getContact()).isEqualTo(s);
	}

	@Test
	void getAdminById() {
		long id = 152;
		Optional<Admin> identity = adminRepository.findById(id);
		assertThat(identity.get().getId()).isEqualTo(identity);

	}

	@Test
	void deleteAdmin() {

		// adding new Admin to database
		adminRepository.save(new Admin("kuberkanade", "sailila80@gmail.com", "9887056435"));

		// getting the id of that new entry
		Admin identity = adminRepository.getAdminByEmail("sailila80@gmail.com");
		Long id = identity.getId();

		// now deleting that entry again
		adminRepository.deleteById(id);

		// checking if that object is deleted or not
		Optional<Admin> delete = adminRepository.findById(id);
		assertNull(delete.get());
	}

	// REPORTS

	@SuppressWarnings("unlikely-arg-type")
	@Test
	void getReportByPatient() {
		long id = 2;
		List<Report> report = reportRepository.getReportByPatient(id);
		assertThat(report.contains(report)).isEqualTo(report);
	}

	@Test
	void addNewReport() {
		Report report = new Report();
		Report saved = reportRepository.save(report);
		assertNotNull(saved);
	}

	// Patients

	@Test
	void addNewPatient() {
		Patient patient = new Patient("Kuber", "Kanade", "kuberkanade", "kuberkanade@yahoomail.com", "2010-03-25",
				"9028280142", "MALE", "Sankalpana Heights", "kkuhbe", "Pune", "MAHARASHTRA", "Pune", 410515, "AADHAAR",
				"400349953448", 80, "O_RHD_POSITIVE", "VERIFIED");
		Patient saved = patientRepository.save(patient);
		assertNotNull(saved);
	}

	@Test
	void getPatientById() {
		long id = 2;
		Optional<Patient> identity = patientRepository.findById(id);
		assertThat(identity.get().getId()).isEqualTo(identity);

	}

	@Test
	void listPatients() {
		List<Patient> list = patientRepository.findAll();
		assertThat(list.contains(list));
	}

	@Test
	void getPatientByEmail() {
		String s = "kuberkanade@yahoomail.com";
		Patient mail = patientRepository.getPatientByEmail(s);
		assertThat(mail.getEmail()).isEqualTo(s);
	}

	@Test
	void getPatientByContact() {
		String s = "9028280142";
		Patient contact = patientRepository.getPatientByContact(s);
		assertThat(contact.getContact()).isEqualTo(s);
	}

	// Bed

	@Test
	void listBeds() {
		List<Bed> list = bedRepository.findAll();
		assertThat(list.contains(list));
	}

	/*
	 * @Test void getBedById() { long id=1; Optional<Bed>
	 * identity=bedRepository.findById(id);
	 * assertThat(identity.get().getId()).isEqualTo(identity);
	 * 
	 * }
	 */

	// Appointments

	@Test
	void getAppointmentById() {
		long id = 12;
		Optional<Appointment> appoint = appointmentRepository.findById(id);
		assertThat(appoint.get().getId()).isEqualTo(id);
	}

	/*
	 * @Test void getAppointmentByPatientId() { long id=12; List<Appointment>
	 * appoint=appointmentRepository.getAppointmentByPatient(id);
	 * assertThat(appoint.get(0).getId()).isEqualTo(id); }
	 */

	/*
	 * @Test void getAppointmentByDoctorId() { long id=12; List<Appointment>
	 * appoint=appointmentRepository.getAppointmentByDoctor(id);
	 * assertThat(appoint.get(0).getId()).isEqualTo(id); }
	 */

	/*
	 * @Test void getAppointmentByDoctorDate() { long id=3; Date date=2023-02-23;
	 * Appointment appoint=appointmentRepository.findByDoctorAndDate(id,date);
	 * assertThat(appoint.getDoctor().getId()).isEqualTo(appoint);
	 * assertThat(appoint.getTimeslot().getTime()).isEqualTo(appoint);
	 * 
	 * }
	 * 
	 * @Test void getAppointmentByPatientDate() { long id=2; Date date=2023-02-23;
	 * Appointment appoint=appointmentRepository.findByPatientAndDate(id,date);
	 * assertThat(appoint.getPatient().getId()).isEqualTo(appoint);
	 * assertThat(appoint.getTimeslot().getTime()).isEqualTo(appoint);
	 * 
	 * }
	 */

	@Test
	void addNewAppointment() {
		Appointment appointment = new Appointment(2, "sailila80@gmail.com", "9887056435");
		Appointment saved = appointmentRepository.save(appointment);
		assertNotNull(saved);
	}

	@Test
	void deleteAppointment() {

		// getting the id of that new entry
		Appointment identity = appointmentRepository.;
		Long id = identity.getId();

		// now deleting that entry again
		appointmentRepository.deleteById(id);

		// checking if that object is deleted or not
		Optional<Appointment> delete = appointmentRepository.findById(id);
		assertNull(delete.get());
	}

	// Bill
	/*
	 * @Test void addNewBill() { Bill bill=new Bill(); Bill
	 * saved=billRepository.save(bill); assertNotNull(saved); }
	 */

	/*
	 * @Test void getBillById() { long id=2; Optional<Bill>
	 * bill=billRepository.findById(id);
	 * assertThat(bill.get().getId()).isEqualTo(id); }
	 */

	/*
	 * void getBillByPatient() { long id=2; List<Bill>
	 * bill=billRepository.getBillByPatient(id);
	 * assertThat(bill.contains(bill)).isEqualTo(bill); }
	 */

	// Doctor

	@Test
	void addNewDoctor() {
		Doctor doctor = new Doctor();
		Doctor saved = doctorRepository.save(doctor);
		assertNotNull(saved);
	}

	@Test
	void getDoctorByEmail() {
		String s = "kuberkanade85@gmail.com";
		Doctor mail = doctorRepository.getDoctorByEmail(s);
		assertThat(mail.getEmail()).isEqualTo(s);
	}

	@Test
	void getDoctorByContact() {
		String s = "9970215181";
		Doctor contact = doctorRepository.getDoctorByContact(s);
		assertThat(contact.getContact()).isEqualTo(s);
	}

	@Test
	void getDoctorByDepartment() {
		long id = 1;
		List<Doctor> docdep = doctorRepository.getDoctorByDepartmentId(id);
		assertThat(docdep.get(0).getDepartment()).isEqualTo(id);
	}

	@Test
	void getAppointmentByDoctorId() {
		long id = 3;
		List<Appointment> appoint = appointmentController.getAppointmentByDoctor(id);
		assertThat(appoint.get(0)).isEqualTo(id);
	}

	@Test
	void getPrescriptionByDoctorId() {
		long id = 2;
		List<Prescription> appoint = prescriptionController.getPrescriptionByPatient(id);
		assertThat(appoint.get(0)).isEqualTo(id);
	}

	@Test
	void deleteDoctor() {
		Doctor identity = doctorRepository.getDoctorByEmail("");
		Long id = identity.getId();

		// now deleting that entry again
		doctorRepository.deleteById(id);

		Optional<Doctor> delete = doctorRepository.findById(id);
		assertNull(delete.get());
	}

}