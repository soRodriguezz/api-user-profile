package com.pch.apiuserprofile.persistence.mappers;

import com.pch.apiuserprofile.domain.entities.Certification;
import com.pch.apiuserprofile.persistence.models.CertificationDAO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring",uses = {UserProfileMapper.class})
public interface CertificationMapper {

    @Mappings({
            @Mapping(source = "idCertification",target = "idCertification"),
            @Mapping(source = "name",target = "name"),
            @Mapping(source = "issuingOrganization",target = "issuingOrganization"),
            @Mapping(source = "issueMonth",target = "issueMonth"),
            @Mapping(source = "issueYear",target = "issueYear"),
            @Mapping(source = "expirationMonth",target = "expirationMonth"),
            @Mapping(source = "expirationYear",target = "expirationYear"),
            @Mapping(source = "credentialURL",target = "credentialURL"),
            @Mapping(source = "userProfile",target = "userProfile"),
    })
    Certification toCertification(CertificationDAO dao);

    List<Certification> toCertifications(List<CertificationDAO> daos);

    @InheritInverseConfiguration
    CertificationDAO toCertificationDAO(Certification certification);
}
