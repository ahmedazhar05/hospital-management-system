package com.healthplus.auth.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Doctor extends HospitalUser implements Serializable {
    private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String hash;
    private String email;
    private String contact;
    private String designation;
    private Long department;
    private String degrees;
    private Date degreeCertificationDate;
    private String imageUrl = "https://www.fortischennai.com/frontend/docimage/M-dtr-1554189149.png";
    private String language = "English";
    private String gender;
    private Integer fees;
    private String description = "<em>No description available</em>";
    private String role = "doctor";

    public Doctor() {
        super();
    }

    public Doctor(String hash, String email, String contact, String designation, Long department, String degrees, Date degreeCertificationDate, String imageUrl, String language, String gender, Integer fees, String description) {
        this.hash = hash;
        this.email = email;
        this.contact = contact;
        this.designation = designation;
        this.department = department;
        this.degrees = degrees;
        this.degreeCertificationDate = degreeCertificationDate;
        this.imageUrl = imageUrl;
        this.language = language;
        this.gender = gender;
        this.fees = fees;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
    
    public Long getDepartment() {
        return department;
    }
    
    public void setDepartment(Long department) {
        this.department = department;
    }

    public String getDegrees() {
        return degrees;
    }

    public void setDegrees(String degrees) {
        this.degrees = degrees;
    }

    public Date getDegreeCertificationDate() {
        return degreeCertificationDate;
    }

    public void setDegreeCertificationDate(Date degreeCertificationDate) {
        this.degreeCertificationDate = degreeCertificationDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getFees() {
        return fees;
    }

    public void setFees(Integer fees) {
        this.fees = fees;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Doctor [id=" + id + ", hash=" + hash + ", email=" + email + ", contact=" + contact + ", designation=" + designation + ", department=" + department + ", degrees=" + degrees + ", degreeCertificationDate=" + degreeCertificationDate + ", imageUrl=" + imageUrl + ", language=" + language + ", gender=" + gender + ", fees=" + fees + ", description=" + description + "]";
    }
}