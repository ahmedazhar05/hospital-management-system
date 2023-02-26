package com.healthplus.auth.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Patient extends HospitalUser implements Serializable {
    private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String hash;
    private String email;
    private Date dateOfBirth;
    private String contact;
    private String gender;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String state;
    private String city;
    private Integer zip;
    private String documentType;
    private String documentNumber;
    private Integer weight;
    private String bloodGroup;
    private String status = "UNVERIFIED";
    private String role = "patient";
    
    public Patient() {
        super();
    }

    public Patient(String firstName, String lastName, String hash, String email, Date dateOfBirth, String contact, String gender, String addressLine1, String addressLine2, String addressLine3, String state, String city, Integer zip, String documentType, String documentNumber, Integer weight, String bloodGroup, String status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hash = hash;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.contact = contact;
        this.gender = gender;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.state = state;
        this.city = city;
        this.zip = zip;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.weight = weight;
        this.bloodGroup = bloodGroup;
        this.status = status;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        // boolean b = Arrays.stream(DOCUMENT_TYPE.values()).anyMatch((Patient.DOCUMENT_TYPE d) -> documentType == d);
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Patient [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", hash=" + hash + ", email=" + email + ", dateOfBirth=" + dateOfBirth + ", contact=" + contact + ", gender=" + gender + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", addressLine3=" + addressLine3 + ", state=" + state + ", city=" + city + ", zip=" + zip + ", documentType=" + documentType + ", documentNumber=" + documentNumber + ", weight=" + weight + ", bloodGroup=" + bloodGroup + ", status=" + status + "]";
    }
}