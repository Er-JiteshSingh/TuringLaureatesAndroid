package com.turinglaureate.modals;

import java.sql.Timestamp;

public class LaureateData {
    private String id;
    private String name;
    private String year;
    private String country;
    private String description;
    private String affiliation;
    private String image;
    private Timestamp timestamp;

    public LaureateData() {
    }

    public LaureateData(String name, String year, String country, String description, String affiliation, String image) {
        this.name = name;
        this.year = year;
        this.country = country;
        this.description = description;
        this.affiliation = affiliation;
        this.image = image;
    }

    public LaureateData(String id, String name, String year, String country, String description, String affiliation, String image, Timestamp timestamp) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.country = country;
        this.description = description;
        this.affiliation = affiliation;
        this.image = image;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
