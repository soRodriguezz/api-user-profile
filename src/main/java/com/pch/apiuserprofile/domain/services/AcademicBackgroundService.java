package com.pch.apiuserprofile.domain.services;

import com.pch.apiuserprofile.domain.entities.AcademicBackground;
import com.pch.apiuserprofile.domain.gateways.AcademicBackgroundGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcademicBackgroundService {

    @Autowired
    private AcademicBackgroundGateway gateway;

    public List<AcademicBackground> getAll(){
        return gateway.getAll();
    }

    Optional<List<AcademicBackground>> getByUserProfile(int idUserProfile){
        return gateway.getByUserProfile(idUserProfile);
    }

    public Optional<AcademicBackground> getAcademicBackgroundById(int id){
        return gateway.getAcademicBackgroundById(id);
    }

    public AcademicBackground saveAcademicBackground(AcademicBackground academicBackground){
        return gateway.saveAcademicBackground(academicBackground);
    }

    public boolean deleteAcademicById(int id){
        return gateway.getAcademicBackgroundById(id).map(academicBackground -> {
            gateway.deleteAcademicBackgroundById(id);
            return true;
        }).orElse(false);
    }
}
