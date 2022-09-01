package com.pch.apiuserprofile.domain.services;

import com.pch.apiuserprofile.domain.entities.AcademicBackground;
import com.pch.apiuserprofile.domain.entities.Certification;
import com.pch.apiuserprofile.domain.entities.UserProfile;
import com.pch.apiuserprofile.domain.gateways.CertificationGateway;
import com.pch.apiuserprofile.domain.gateways.UserProfileGateway;
import com.pch.apiuserprofile.dto.RequestAcademicBackgroundDTO;
import com.pch.apiuserprofile.dto.RequestCertificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificationService {

    @Autowired
    private CertificationGateway gateway;

    @Autowired
    private UserProfileGateway gatewayUserProfile;

    public List<Certification> getAll() {
        return gateway.getAll();
    }

    public Optional<List<Certification>> getByIdUserProfile(int idUserProfile){
        return gateway.getByIdUserProfile(idUserProfile);
    }

    public Optional<Certification> getCertificationById(int id){
        return gateway.getCertificationById(id);
    }

    public Certification saveCertification(RequestCertificationDTO dto){
        Certification certification = new Certification();

        int idUserProfile = dto.getIdUserProfile();
        Optional<UserProfile> userProfile = gatewayUserProfile.getUserProfileById(idUserProfile);

        certification.setName(dto.getName());
        certification.setIssuingOrganization(dto.getIssuingOrganization());
        certification.setIssueMonth(dto.getIssueMonth());
        certification.setIssueYear(dto.getIssueYear());
        certification.setExpirationMonth(dto.getExpirationMonth());
        certification.setExpirationYear(dto.getExpirationYear());
        certification.setCredentialURL(dto.getCredentialURL());
        certification.setIdUserProfile(dto.getIdUserProfile());
        userProfile.ifPresent(certification::setUserProfile);

        return gateway.saveCertificacion(certification);
    }

    public Certification updateCertification(int id, RequestCertificationDTO dto){
        Certification certification = new Certification();

        Optional<Certification> certification1 = gateway.getCertificationById(id);

        certification.setIdCertification(id);
        certification.setName(dto.getName());
        certification.setIssuingOrganization(dto.getIssuingOrganization());
        certification.setIssueMonth(dto.getIssueMonth());
        certification.setIssueYear(dto.getIssueYear());
        certification.setExpirationMonth(dto.getExpirationMonth());
        certification.setExpirationYear(dto.getExpirationYear());
        certification.setCredentialURL(dto.getCredentialURL());
        certification.setIdUserProfile(certification1.get().getIdUserProfile());
        certification.setUserProfile(certification1.get().getUserProfile());

        return gateway.updateCertification(certification);
    }

    public boolean deleCertificationById(int id){
        return getCertificationById(id).map(certification -> {
            gateway.deleteCertificationById(id);
            return true;
        }).orElse(false);
    }
}
