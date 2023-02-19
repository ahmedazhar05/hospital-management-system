package com.healthplus.dataaccess.domain;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;

@Entity
public class Doctor implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public static enum GENDER{
        MALE,
        FEMALE,
        OTHERS
    }

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
    @ManyToOne(optional=false)
    private Department department;

    @NotNull
    private String degrees;

    @NotNull
    @Past
    private Date degreeCertificationDate;

    @NotNull
    private String imageUrl; // TODO: assign a default image URL to this

    @NotNull
    private String language = "English";

    @NotNull
    private GENDER gender;

    @NotNull
    @Positive
    private Integer fees;

    private String description;

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
}
