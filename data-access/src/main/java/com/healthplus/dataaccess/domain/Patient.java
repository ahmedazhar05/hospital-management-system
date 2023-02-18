package com.healthplus.dataaccess.domain;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

@Entity
public class Patient implements Serializable {
    private static final long serialVersionUID = 1L;

	private enum DOCUMENT_TYPE{
		AADHAR,
		PAN,
		VOTER_ID,
		LICENSE
	}
	private enum BLOOD_GROUP{
		A_RHD_POSITIVE("A+"),
		A_RHD_NEGATIVE("A-"),
		B_RHD_POSITIVE("B+"),
		B_RHD_NEGATIVE("B-"),
		O_RHD_POSITIVE("O+"),
		O_RHD_NEGATIVE("O-"),
		AB_RHD_POSITIVE("AB+"),
		AB_RHD_NEGATIVE("AB-");
		
		public final String label;

	    private BLOOD_GROUP(String label) {
	        this.label = label;
	    }
	}
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @NotNull(message="First name is required")
    private String firstName;

    @NotNull(message="Last name is required")
    private String lastName;

    @NotNull(message="Password is required")
    private String hash;

    @NotNull(message="Email is required")
    @Email
    private String email;

    @NotNull(message="Date of Birth is required")
    @Past
    private Date dateOfBirth;

    @NotNull(message="Contact number is required")
    @Digits(fraction = 0, integer = 10)
    @Positive
    private long contact;

    @NotNull(message="Gender is required")
    private char gender;

    @NotNull(message="First address line is required")
    private String addressLine1;

    private String addressLine2;

    private String addressLine3;

    @NotNull(message="State is required")
    private String state;

    @NotNull(message="City is required")
    private String city;

    @NotNull(message="Zip is required")
    @Digits(fraction = 0, integer = 6)
    private int zip;

    @NotNull(message="ID document is required")
    @Enumerated(EnumType.STRING)
    private DOCUMENT_TYPE documentType;

    @NotNull(message="ID document number is required")
    @Pattern(regexp="[A-Z]{3}[PCHABGJLFT][A-Z][0-9]{4}[A-Z]")
    @Pattern(regexp="[2-9][0-9]{11}")
    @Pattern(regexp="[A-Z]{3}[0-9]{7}")
    @Pattern(regexp="[A-Z]{2}[0-9]{13}")
    private String documentNumber;

    @Digits(fraction = 0, integer = 3)
    private int weight;

    @Enumerated(EnumType.STRING)
    private BLOOD_GROUP bloodGroup;

    private boolean status = false;

    private boolean isBlocked = false;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
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

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public DOCUMENT_TYPE getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DOCUMENT_TYPE documentType) {
		// boolean b = Arrays.stream(DOCUMENT_TYPE.values()).anyMatch((Patient.DOCUMENT_TYPE d) -> documentType == d);
		this.documentType = documentType;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public BLOOD_GROUP getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(BLOOD_GROUP bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isBlocked() {
		return isBlocked;
	}

	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}
}