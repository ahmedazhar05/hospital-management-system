package com.healthplus.processmanagement.model;

import java.io.Serializable;
import java.util.Date;

public class Patient implements Serializable {
    private static final long serialVersionUID = 1L;

    public static enum DOCUMENT_TYPE{
        AADHAR,
        PAN,
        VOTER_ID,
        DRIVING_LICENSE
    }
    public static enum BLOOD_GROUP{
        A_RHD_POSITIVE,
        A_RHD_NEGATIVE,
        B_RHD_POSITIVE,
        B_RHD_NEGATIVE,
        O_RHD_POSITIVE,
        O_RHD_NEGATIVE,
        AB_RHD_POSITIVE,
        AB_RHD_NEGATIVE,
        RH_NULL
    }
    public static enum STATUS{
        UNVERIFIED,
        VERIFIED,
        BLOCKED
    }
    public static enum GENDER{
        MALE,
        FEMALE,
        OTHERS
    }
    
    public static enum STATE{
        ANDHRA_PRADESH,
        ARUNACHAL_PRADESH,
        ASSAM,
        BIHAR,
        CHHATTISGARH,
        GOA,
        GUJARAT,
        HARYANA,
        HIMACHAL_PRADESH,
        JHARKHAND,
        KARNATAKA,
        KERALA,
        MADHYA_PRADESH,
        MAHARASHTRA,
        MANIPUR,
        MEGHALAYA,
        MIZORAM,
        NAGALAND,
        ODISHA,
        PUNJAB,
        RAJASTHAN,
        SIKKIM,
        TAMIL_NADU,
        TELANGANA,
        TRIPURA,
        UTTAR_PRADESH,
        UTTARAKHAND,
        WEST_BENGAL,
        ANDAMAN_AND_NICOBAR_ISLANDS,
        CHANDIGARH,
        DADRA_AND_NAGAR_HAVELI_AND_DAMAN_AND_DIU,
        DELHI,
        JAMMU_AND_KASHMIR,
        LADAKH,
        LAKSHADWEEP,
        PUDUCHERRY
    }
    
    private Long id;
    private String firstName;
    private String lastName;
    private String hash;
    private String email;
    private Date dateOfBirth;
    private String contact;
    private GENDER gender;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private STATE state;
    private String city;
    private Integer zip;
    private DOCUMENT_TYPE documentType;
    private String documentNumber;
    private Integer weight;
    private BLOOD_GROUP bloodGroup;
    private STATUS status = STATUS.UNVERIFIED;
    
    public Patient() {
        super();
    }

    public Patient(String firstName, String lastName, String hash, String email, Date dateOfBirth, String contact, GENDER gender, String addressLine1, String addressLine2, String addressLine3, STATE state, String city, Integer zip, DOCUMENT_TYPE documentType, String documentNumber, Integer weight, BLOOD_GROUP bloodGroup, STATUS status) {
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

    public GENDER getGender() {
        return gender;
    }

    public void setGender(GENDER gender) {
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

    public STATE getState() {
        return state;
    }

    public void setState(STATE state) {
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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public BLOOD_GROUP getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BLOOD_GROUP bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Patient [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", hash=" + hash + ", email=" + email + ", dateOfBirth=" + dateOfBirth + ", contact=" + contact + ", gender=" + gender + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", addressLine3=" + addressLine3 + ", state=" + state + ", city=" + city + ", zip=" + zip + ", documentType=" + documentType + ", documentNumber=" + documentNumber + ", weight=" + weight + ", bloodGroup=" + bloodGroup + ", status=" + status + "]";
    }
}