package com.healthplus.auth.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.healthplus.auth.manager.AdminRepository;
import com.healthplus.auth.manager.DoctorRepository;
import com.healthplus.auth.manager.PatientRepository;
import com.healthplus.auth.model.HospitalUser;
import com.healthplus.auth.model.Patient;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	// @Value("${jpa.domain}")
	/*
	private String DOMAIN = "http://localhost:8080";

	private RestTemplate restTemplate = new RestTemplate();

	private final String URI = DOMAIN + "/users/search";
*/
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private DoctorRepository doctorRepository;
	@Autowired
	private AdminRepository adminRepository;
	
	public HospitalUser fetchUser(String credential) {

		HospitalUser user;
		
		String role = "patient";
		user = patientRepository.getPatientByEmail(role);
		if(user != null) {
			user.setRole(role);
			user.setCredential(credential);
			return user;
		}
		user = patientRepository.getPatientByContact(credential);
		if(user != null) {
			user.setRole(role);
			user.setCredential(credential);
			return user;
		}
		role = "doctor";
		user = doctorRepository.getDoctorByEmail(credential);
		if(user != null) {
			user.setRole(role);
			user.setCredential(credential);
			return user;
		}
		user = doctorRepository.getDoctorByContact(credential);
		if(user != null) {
			user.setRole(role);
			user.setCredential(credential);
			return user;
		}
		role = "admin";
		user = adminRepository.getAdminByEmail(credential);
		if(user != null) {
			user.setRole(role);
			return user;
		}
		user = adminRepository.getAdminByContact(credential);
		if(user != null) {
			user.setRole(role);
			user.setCredential(credential);
			return user;
		}
		return user;
	}
	
	@Override
	public UserDetails loadUserByUsername(String credential) throws UsernameNotFoundException {
		System.out.println("JwtUserDetailsService::loadUserByUsername()");
		/*
		HospitalUser hu = restTemplate.getForObject(URI + "?credential=" + credential, HospitalUser.class);
		
		String username = hu.getRole() + ":" + hu.getId() + ":" + credential;
		System.out.println(username);
		*/

		System.out.print("Before");
		HospitalUser hu = fetchUser(credential);
		System.out.print("After");
		
		// HospitalUser hu = new Patient();
		String pwd = new BCryptPasswordEncoder().encode("something");
		System.out.print("\n\n" + pwd);
		return new User("9876543210", new BCryptPasswordEncoder().encode("12345678912346579"), new ArrayList<>(0));
		/*
		if (hu != null) {
			return new User(credential, pwd, new ArrayList<>(0));
		} else {
			System.out.print("okay");
			throw new UsernameNotFoundException("User not found with credential: " + credential);
		}
		*/
		/*
		if ("randomuser123".equals(credential)) {
			return new User(credential, pwd, //"$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + credential);
		}
*/
		/*
		 * HospitalUser user = restTemplate.getForObject(this.URI + "?credential=" +
		 * credential, HospitalUser.class); System.out.println("HOSPITAL_USER: " +
		 * user); if(user == null) { throw new
		 * UsernameNotFoundException("User not found with credential: " + credential); }
		 * return user; /* if (user.getCredential().equals(credential)) { return user; }
		 * else { throw new UsernameNotFoundException("User not found with credential: "
		 * + credential); }
		 */
	}
}