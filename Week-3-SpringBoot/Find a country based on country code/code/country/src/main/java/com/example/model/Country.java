package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "country")
public class Country {

    @Id
    private String coCode;

    private String coName;

    // Default constructor
    public Country() {}

    // Getters and setters
    public String getCoCode() {
        return coCode;
    }
    public void setCoCode(String coCode) {
        this.coCode = coCode;
    }

    public String getCoName() {
        return coName;
    }
    public void setCoName(String coName) {
        this.coName = coName;
    }
}
