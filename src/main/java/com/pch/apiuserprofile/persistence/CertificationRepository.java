package com.pch.apiuserprofile.persistence;

import com.pch.apiuserprofile.domain.entities.AcademicBackground;
import com.pch.apiuserprofile.domain.entities.Certification;
import com.pch.apiuserprofile.domain.gateways.CertificationGateway;
import com.pch.apiuserprofile.persistence.crud.CertificationCrudRepository;
import com.pch.apiuserprofile.persistence.mappers.AcademicBackgroundMapper;
import com.pch.apiuserprofile.persistence.mappers.CertificationMapper;
import com.pch.apiuserprofile.persistence.models.AcademicBackgroundDAO;
import com.pch.apiuserprofile.persistence.models.CertificationDAO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CertificationRepository implements CertificationGateway {

    private final CertificationCrudRepository crudRepository;

    private final CertificationMapper mapper;

    public CertificationRepository(CertificationCrudRepository crudRepository, CertificationMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Certification> getAll() {
        List<CertificationDAO> daos = (List<CertificationDAO>) crudRepository.findAll();
        return mapper.toCertifications(daos);
    }

    @Override
    public Optional<List<Certification>> getByIdUserProfile(int idUserProfile) {
        List<CertificationDAO> daos = crudRepository.findByIdUserProfile(idUserProfile);
        return Optional.ofNullable(mapper.toCertifications(daos));
    }

    @Override
    public Optional<Certification> getCertificationById(int id) {
        CertificationDAO certificationDAO = crudRepository.findById(id).get();
        return Optional.ofNullable(mapper.toCertification(certificationDAO));
    }

    @Override
    public Certification saveCertificacion(Certification certification) {
        CertificationDAO certificationDAO = crudRepository.save(mapper.toCertificationDAO(certification));
        return mapper.toCertification(certificationDAO);
    }

    @Override
    public Certification updateCertification(Certification certification) {
        CertificationDAO certificationDAO = crudRepository.save(mapper.toCertificationDAO(certification));
        return mapper.toCertification(certificationDAO);
    }

    @Override
    public void deleteCertificationById(int id) {
        crudRepository.deleteById(id);
    }
}
