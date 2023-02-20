package com.healthplus.processmanagement.model;

import java.io.Serializable;
import java.util.Date;

public class Doctor implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public static enum GENDER{
        MALE,
        FEMALE,
        OTHERS
    }

    private Long id;
    private String firstName;
    private String lastName;
    private String hash;
    private String email;
    private String contact;
    private String designation;
    private Department department;
    private String degrees;
    private Date degreeCertificationDate;
    private String imageUrl; // TODO: assign a default image URL to this
    private String language = "English";
    private GENDER gender;
    private Integer fees;
    private String description = "<em>No description available</em>";

    public Doctor() {
        super();
    }

    public Doctor(String hash, String email, String contact, String designation, Department department, String degrees, Date degreeCertificationDate, String imageUrl, String language, GENDER gender, Integer fees, String description) {
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
    
    public Department getDepartment() {
        return department;
    }
    
    public void setDepartment(Department department) {
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

    public GENDER getGender() {
        return gender;
    }

    public void setGender(GENDER gender) {
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
