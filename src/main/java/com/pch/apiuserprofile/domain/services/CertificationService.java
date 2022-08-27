package com.pch.apiuserprofile.domain.services;

import com.pch.apiuserprofile.domain.entities.Certification;
import com.pch.apiuserprofile.domain.gateways.CertificationGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificationService {

    @Autowired
    private CertificationGateway gateway;

    public List<Certification> getAll() {
        return gateway.getAll();
    }

    Optional<List<Certification>> getByUserProfile(int idUserProfile){
        return gateway.getByUserProfile(idUserProfile);
    }

    public Optional<Certification> getCertificationById(int id){
        return gateway.getCertificationById(id);
    }

    public Certification saveCertification(Certification certification){
        return gateway.saveCertificacion(certification);
    }

    public boolean deleCertificationById(int id){
        return getCertificationById(id).map(certification -> {
            gateway.deleteCertificationById(id);
            return true;
        }).orElse(false);
    }
}
