package com.healthplus.processmanagement.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Report implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Patient patient;
    private String name;
    private Date date = new Date();
    private String fileUrl;

    public Report() {
        super();
    }

    public Report(Patient patient, String name, Date date, String fileUrl) {
        this.patient = patient;
        this.name = name;
        this.date = date;
        this.fileUrl = fileUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    @Override
    public String toString() {
        return "Report [id=" + id + ", patient=" + patient + ", name=" + name + ", date=" + date + ", fileUrl=" + fileUrl + "]";
    }
}