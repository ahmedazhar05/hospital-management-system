package com.healthplus.processmanagement.model;

import java.io.Serializable;

public class Admin implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String hash;
    private String email;
    private String contact;

    public Admin() {
        super();
    }

    public Admin(String hash, String email, String contact) {
        this.hash = hash;
        this.email = email;
        this.contact = contact;
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

    @Override
    public String toString() {
        return "Admin [id=" + id + ", hash=" + hash + ", email=" + email + ", contact=" + contact + "]";
    }
}