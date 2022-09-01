package com.pch.apiuserprofile.dto;

public class RequestWorkExperienceDTO {
    private int idWorkExperience;
    private String title;
    private String employmentType;
    private String companyName;
    private String location;
    private int startMonth;
    private int endMonth;
    private int startYear;
    private int endYear;
    private String description;
    private int idUserProfile;

    public int getIdWorkExperience() {
        return idWorkExperience;
    }

    public void setIdWorkExperience(int idWorkExperience) {
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

    public int getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(int startMonth) {
        this.startMonth = startMonth;
    }

    public int getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(int endMonth) {
        this.endMonth = endMonth;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdUserProfile() {
        return idUserProfile;
    }

    public void setIdUserProfile(int idUserProfile) {
        this.idUserProfile = idUserProfile;
    }
}
