package com.healthplus.dataaccess.domain;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

@Entity
public class Doctor implements Serializable {
    private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotNull
    private String hash;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String contact;

    @NotNull
    private String designation;

    @NotNull
    private String department;

    @NotNull
    private String degrees;

    @NotNull
    @Past
    private Date degreeCertificationDate;

    @NotNull
    private String imageUrl;

    @NotNull
    private String language;

    @NotNull
    private Character gender;

    @NotNull
    private Integer fees;

    private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	@OneToOne(optional=false)
	@JoinColumn(name="department_id", referencedColumnName="id")
	public String getDepartment() {
		return department;
	}
	

	public void setDepartment(String department) {
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

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
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
}