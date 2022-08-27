package com.pch.apiuserprofile.persistence;

import com.pch.apiuserprofile.domain.entities.Certification;
import com.pch.apiuserprofile.domain.gateways.CertificationGateway;
import com.pch.apiuserprofile.persistence.crud.CertificationCrudRepository;
import com.pch.apiuserprofile.persistence.mappers.AcademicBackgroundMapper;
import com.pch.apiuserprofile.persistence.mappers.CertificationMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CertificationRepository implements CertificationGateway {

    private CertificationCrudRepository crudRepository;

    private CertificationMapper mapper;

    public CertificationRepository(CertificationCrudRepository crudRepository, CertificationMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Certification> getAll() {
        return null;
    }

    @Override
    public Optional<List<Certification>> getByUserProfile(int idUserProfile) {
        return Optional.empty();
    }

    @Override
    public Optional<Certification> getCertificationById(int id) {
        return Optional.empty();
    }

    @Override
    public Certification saveCertificacion(Certification certification) {
        return null;
    }

    @Override
    public void deleteCertificationById(int id) {

    }
}
