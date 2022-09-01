package com.pch.apiuserprofile.domain.services;

import com.pch.apiuserprofile.domain.entities.UserProfile;
import com.pch.apiuserprofile.domain.entities.WorkExperience;
import com.pch.apiuserprofile.domain.gateways.UserProfileGateway;
import com.pch.apiuserprofile.domain.gateways.WorkExperienceGateway;
import com.pch.apiuserprofile.dto.RequestWorkExperienceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkExperienceService {

    @Autowired
    private WorkExperienceGateway gateway;

    @Autowired
    private UserProfileGateway gatewayUserProfile;

    public List<WorkExperience> getAll(){
        return gateway.getAll();
    }

    public Optional<List<WorkExperience>> getByIdUserProfile(int idUserProfile){
        return gateway.getByIdUserProfile(idUserProfile);
    }

    public Optional<WorkExperience> getWorkExperienceById(int id){
        return gateway.getWorkExperienceById(id);
    }

    public WorkExperience saveWorkExperience(RequestWorkExperienceDTO dto){
        WorkExperience workExperience = new WorkExperience();

        int idUserProfile = dto.getIdUserProfile();
        Optional<UserProfile> userProfile = gatewayUserProfile.getUserProfileById(idUserProfile);

        workExperience.setTitle(dto.getTitle());
        workExperience.setEmploymentType(dto.getEmploymentType());
        workExperience.setCompanyName(dto.getCompanyName());
        workExperience.setLocation(dto.getLocation());
        workExperience.setStartMonth(dto.getStartMonth());
        workExperience.setEndMonth(dto.getEndMonth());
        workExperience.setStartYear(dto.getStartYear());
        workExperience.setEndYear(dto.getEndYear());
        workExperience.setDescription(dto.getDescription());
        workExperience.setIdUserProfile(dto.getIdUserProfile());
        userProfile.ifPresent(workExperience::setUserProfile);

        return gateway.saveWorkExperience(workExperience);
    }

    public WorkExperience updateWorkExperience(int id, RequestWorkExperienceDTO dto){
        WorkExperience workExperience = new WorkExperience();

        Optional<WorkExperience> workExperience1 = gateway.getWorkExperienceById(id);

        workExperience.setIdWorkExperience(id);
        workExperience.setTitle(dto.getTitle());
        workExperience.setEmploymentType(dto.getEmploymentType());
        workExperience.setCompanyName(dto.getCompanyName());
        workExperience.setLocation(dto.getLocation());
        workExperience.setStartMonth(dto.getStartMonth());
        workExperience.setEndMonth(dto.getEndMonth());
        workExperience.setStartYear(dto.getStartYear());
        workExperience.setEndYear(dto.getEndYear());
        workExperience.setDescription(dto.getDescription());
        workExperience.setIdUserProfile(workExperience1.get().getIdUserProfile());
        workExperience.setUserProfile(workExperience1.get().getUserProfile());

        return gateway.updateWorkExperience(workExperience);
    }

    public boolean deleteWorkExperienceById(int id){
        return gateway.getWorkExperienceById(id).map(workExperience -> {
            gateway.deleteWorkExperienceById(id);
            return true;
        }).orElse(false);
    }
}
