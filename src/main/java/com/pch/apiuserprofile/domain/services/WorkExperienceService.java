package com.pch.apiuserprofile.domain.services;

import com.pch.apiuserprofile.domain.entities.AcademicBackground;
import com.pch.apiuserprofile.domain.entities.WorkExperience;
import com.pch.apiuserprofile.domain.gateways.WorkExperienceGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkExperienceService {

    @Autowired
    private WorkExperienceGateway gateway;

    public List<WorkExperience> getAll(){
        return gateway.getAll();
    }

    Optional<List<WorkExperience>> getByUserProfile(int idUserProfile){
        return gateway.getByUserProfile(idUserProfile);
    }

    public Optional<WorkExperience> getAcademicBackgroundById(int id){
        return gateway.getWorkExperienceById(id);
    }

    public WorkExperience saveAcademicBackground(WorkExperience workExperience){
        return gateway.saveWorkExperience(workExperience);
    }

    public boolean deleteAcademicById(int id){
        return gateway.getWorkExperienceById(id).map(workExperience -> {
            gateway.deleteWorkExperienceById(id);
            return true;
        }).orElse(false);
    }
}
