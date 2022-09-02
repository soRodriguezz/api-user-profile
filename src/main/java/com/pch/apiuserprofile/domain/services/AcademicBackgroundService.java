package com.pch.apiuserprofile.domain.services;

import com.pch.apiuserprofile.domain.entities.AcademicBackground;
import com.pch.apiuserprofile.domain.entities.UserProfile;
import com.pch.apiuserprofile.domain.entities.WorkExperience;
import com.pch.apiuserprofile.domain.gateways.AcademicBackgroundGateway;
import com.pch.apiuserprofile.domain.gateways.UserProfileGateway;
import com.pch.apiuserprofile.dto.RequestAcademicBackgroundDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AcademicBackgroundService {

    @Autowired
    private AcademicBackgroundGateway gateway;

    @Autowired
    private UserProfileGateway gatewayUserProfile;

    public List<AcademicBackground> getAll(){
        return gateway.getAll();
    }

    public Optional<List<AcademicBackground>> getByIdUserProfile(int idUserProfile){
        return gateway.getByIdUserProfile(idUserProfile);
    }

    public Optional<AcademicBackground> getAcademicBackgroundById(int id){
        return gateway.getAcademicBackgroundById(id);
    }

    public AcademicBackground saveAcademicBackground(RequestAcademicBackgroundDTO dto){
        AcademicBackground academicBackground = new AcademicBackground();

        int idUserProfile = dto.getIdUserProfile();
        Optional<UserProfile> userProfile = gatewayUserProfile.getUserProfileById(idUserProfile);

        academicBackground.setSchool(dto.getSchool());
        academicBackground.setDegree(dto.getDegree());
        academicBackground.setStartMonth(dto.getStartMonth());
        academicBackground.setEndMonth(dto.getEndMonth());
        academicBackground.setStartYear(dto.getStartYear());
        academicBackground.setEndYear(dto.getEndYear());
        academicBackground.setGrade(dto.getGrade());
        academicBackground.setDescription(dto.getDescription());
        academicBackground.setIdUserProfile(dto.getIdUserProfile());
        userProfile.ifPresent(academicBackground::setUserProfile);

        return gateway.saveAcademicBackground(academicBackground);
    }

    public AcademicBackground updateAcademicBackground(int id, RequestAcademicBackgroundDTO dto){
        AcademicBackground academicBackground = new AcademicBackground();

        Optional<AcademicBackground> academicBackground1 = gateway.getAcademicBackgroundById(id);

        academicBackground.setIdAcademicBackground(id);
        academicBackground.setSchool(dto.getSchool());
        academicBackground.setDegree(dto.getDegree());
        academicBackground.setStartMonth(dto.getStartMonth());
        academicBackground.setEndMonth(dto.getEndMonth());
        academicBackground.setStartYear(dto.getStartYear());
        academicBackground.setEndYear(dto.getEndYear());
        academicBackground.setGrade(dto.getGrade());
        academicBackground.setDescription(dto.getDescription());
        academicBackground.setCurrentlyStudying(dto.isCurrentlyStudying());
        academicBackground.setIdUserProfile(academicBackground1.get().getIdUserProfile());
        academicBackground.setUserProfile(academicBackground1.get().getUserProfile());

        return gateway.updateAcademicBackground(academicBackground);
    }

    public boolean deleteAcademicById(int id){
        return gateway.getAcademicBackgroundById(id).map(academicBackground -> {
            gateway.deleteAcademicBackgroundById(id);
            return true;
        }).orElse(false);
    }
}
