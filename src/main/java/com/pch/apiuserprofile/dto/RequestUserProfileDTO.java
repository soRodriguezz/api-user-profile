package com.pch.apiuserprofile.dto;

import java.util.Date;

public class RequestUserProfileDTO {
    private int idUserProfile;
    private String name;
    private String lastname;
    private String document;
    private String email;
    private boolean changeResidence;
    private Date dateBirth;
    private String address;
    private String descriptionTechnologies;
    private int experienceYears;
    private int age;

    public int getIdUserProfile() {
        return idUserProfile;
    }

    public void setIdUserProfile(int idUserProfile) {
        this.idUserProfile = idUserProfile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isChangeResidence() {
        return changeResidence;
    }

    public void setChangeResidence(boolean changeResidence) {
        this.changeResidence = changeResidence;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescriptionTechnologies() {
        return descriptionTechnologies;
    }

    public void setDescriptionTechnologies(String descriptionTechnologies) {
        this.descriptionTechnologies = descriptionTechnologies;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
