package com.pch.apiuserprofile.persistence.models;

import javax.persistence.*;

@Entity
@Table(name = "certification")
public class CertificationDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_certification")
    private Integer idCertification;

    private String name;

    @Column(name = "issuing_organization")
    private String issuingOrganization;

    @Column(name = "issue_month")
    private Integer issueMonth;

    @Column(name = "issue_year")
    private Integer issueYear;

    @Column(name = "expiration_month")
    private Integer expirationMonth;

    @Column(name = "expiration_year")
    private Integer expirationYear;

    @Column(name = "credential_url")
    private String credentialURL;

    @ManyToOne
    @JoinColumn(name = "id_user_profile",insertable = false,updatable = false)
    private UserProfileDAO userProfile;

    public Integer getIdCertification() {
        return idCertification;
    }

    public void setIdCertification(Integer idCertification) {
        this.idCertification = idCertification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIssuingOrganization() {
        return issuingOrganization;
    }

    public void setIssuingOrganization(String issuingOrganization) {
        this.issuingOrganization = issuingOrganization;
    }

    public Integer getIssueMonth() {
        return issueMonth;
    }

    public void setIssueMonth(Integer issueMonth) {
        this.issueMonth = issueMonth;
    }

    public Integer getIssueYear() {
        return issueYear;
    }

    public void setIssueYear(Integer issueYear) {
        this.issueYear = issueYear;
    }

    public Integer getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(Integer expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public Integer getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(Integer expirationYear) {
        this.expirationYear = expirationYear;
    }

    public String getCredentialURL() {
        return credentialURL;
    }

    public void setCredentialURL(String credentialURL) {
        this.credentialURL = credentialURL;
    }

    public UserProfileDAO getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfileDAO userProfile) {
        this.userProfile = userProfile;
    }
}
