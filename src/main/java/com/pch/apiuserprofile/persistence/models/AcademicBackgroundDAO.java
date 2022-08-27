package com.pch.apiuserprofile.persistence.models;

import javax.persistence.*;

@Entity
@Table(name = "academic_background")
public class AcademicBackgroundDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_academic_background")
    private Integer idAcademicBackground;

    private String school;

    private String degree;

    @Column(name = "start_month")
    private Integer startMonth;

    @Column(name = "end_month")
    private Integer endMonth;

    @Column(name = "start_year")
    private Integer startYear;

    @Column(name = "end_year")
    private Integer endYear;

    private String grade;

    private String description;

    @ManyToOne
    @JoinColumn(name = "id_user_profile",insertable = false,updatable = false)
    private UserProfileDAO userProfile;

    public Integer getIdAcademicBackground() {
        return idAcademicBackground;
    }

    public void setIdAcademicBackground(Integer idAcademicBackground) {
        this.idAcademicBackground = idAcademicBackground;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
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
