package com.pch.apiuserprofile.domain.gateways;

import com.pch.apiuserprofile.domain.entities.Certification;

import java.util.List;
import java.util.Optional;

public interface CertificationGateway {
    List<Certification> getAll();

    Optional<List<Certification>> getByIdUserProfile(int idUserProfile);

    Optional<Certification> getCertificationById(int id);

    Certification saveCertificacion(Certification certification);

    Certification updateCertification(Certification certification);

    void deleteCertificationById(int id);
}
