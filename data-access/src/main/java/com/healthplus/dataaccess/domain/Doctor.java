package com.healthplus.dataaccess.domain;

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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
public class Doctor extends User implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public static enum GENDER{
        MALE,
        FEMALE,
        OTHERS
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotNull(message="First name is required")
    private String firstName;

    @NotNull(message="Last name is required")
    private String lastName;

    @NotNull(message="Password is required")
    private String hash;

    @NotNull(message="Email is required")
    @Email(message="Email should be valid")
    private String email;

    @NotNull(message="Contact number is required")
    @Size(min = 10, max = 10, message = "Contact number should be a valid 10 digit number")
    private String contact;

    @NotNull(message="Designation is required")
    private String designation;

    @NotNull(message="Department is required")
    @ManyToOne(optional=false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Department department;

    @NotNull(message="Degree is required")
    private String degrees;

    @NotNull(message="Degree Certification Date is required")
    @Past(message="Degree Certification Date cannot be in the future")
    private Date degreeCertificationDate;

    private String imageUrl; // TODO: assign a default image URL to this

    private String language = "English";

    @NotNull(message="Gender is required")
    @Enumerated(EnumType.STRING)
    private GENDER gender;

    @NotNull(message="Doctor fees is required")
    @Min(value = 0, message="Doctor fees cannot be negative")
    private Integer fees;

    private String description = "<em>No description available</em>";
    
    private String role = "doctor";

    public Doctor() {
        super();
    }

    public Doctor(@NotNull String hash, @NotNull @Email String email, @NotNull String contact, @NotNull String designation, @NotNull Department department, @NotNull String degrees, @NotNull @Past Date degreeCertificationDate, @NotNull String imageUrl, @NotNull String language, @NotNull GENDER gender, @NotNull @Positive Integer fees, String description) {
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
