package com.pch.apiuserprofile.persistence.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user_profile")
public class UserProfileDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_profile")
    private Integer idUserProfile;

    private String name;

    private String lastname;

    private String document;

    private String email;

    @Column(name = "change_residence")
    private boolean changeResidence;

    @Column(name = "date_birth")
    private Date dateBirth;

    private String address;

    //TODO
    @OneToMany(mappedBy = "userProfile")
    private List<WorkExperienceDAO> workExperience;

    @OneToMany(mappedBy = "userProfile")
    private List<AcademicBackgroundDAO> academicBackground;

    @OneToMany(mappedBy = "userProfile")
    private List<CertificationDAO> certification;

    @Column(name = "description_technologies")
    private String descriptionTechnologies;

    @Column(name = "experience_years")
    private int experienceYear;

    private int age;

    public Integer getIdUserProfile() {
        return idUserProfile;
    }

    public void setIdUserProfile(Integer idUserProfile) {
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

    public int getExperienceYear() {
        return experienceYear;
    }

    public void setExperienceYear(int experienceYear) {
        this.experienceYear = experienceYear;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<WorkExperienceDAO> getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(List<WorkExperienceDAO> workExperience) {
        this.workExperience = workExperience;
    }

    public List<AcademicBackgroundDAO> getAcademicBackground() {
        return academicBackground;
    }

    public void setAcademicBackground(List<AcademicBackgroundDAO> academicBackground) {
        this.academicBackground = academicBackground;
    }

    public List<CertificationDAO> getCertification() {
        return certification;
    }

    public void setCertification(List<CertificationDAO> certification) {
        this.certification = certification;
    }
}
