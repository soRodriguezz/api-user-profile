package com.pch.apiuserprofile.persistence.models;

import javax.persistence.*;

@Entity
@Table(name = "work_experience")
public class WorkExperienceDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_work_experience")
    private Integer idWorkExperience;

    private String title;

    @Column(name = "employment_type")
    private String employmentType;

    @Column(name = "company_name")
    private String companyName;

    private String location;

    @Column(name = "start_month")
    private Integer startMonth;

    @Column(name = "end_month")
    private Integer endMonth;

    @Column(name = "start_year")
    private Integer startYear;

    @Column(name = "end_year")
    private Integer endYear;

    private String description;

    @ManyToOne
    @JoinColumn(name = "id_user_profile",insertable = false,updatable = false)
    private UserProfileDAO userProfile;

    public Integer getIdWorkExperience() {
        return idWorkExperience;
    }

    public void setIdWorkExperience(Integer idWorkExperience) {
        this.idWorkExperience = idWorkExperience;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(Integer startMonth) {
        this.startMonth = startMonth;
    }

    public Integer getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(Integer endMonth) {
        this.endMonth = endMonth;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserProfileDAO getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfileDAO userProfile) {
        this.userProfile = userProfile;
    }
}
