package com.pch.apiuserprofile.persistence.mappers;

import com.pch.apiuserprofile.domain.entities.AcademicBackground;
import com.pch.apiuserprofile.domain.entities.Certification;
import com.pch.apiuserprofile.domain.entities.UserProfile;
import com.pch.apiuserprofile.domain.entities.WorkExperience;
import com.pch.apiuserprofile.persistence.models.AcademicBackgroundDAO;
import com.pch.apiuserprofile.persistence.models.CertificationDAO;
import com.pch.apiuserprofile.persistence.models.UserProfileDAO;
import com.pch.apiuserprofile.persistence.models.WorkExperienceDAO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {

    @Mappings({
            @Mapping(source = "idUserProfile", target = "idUserProfile"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "lastname", target = "lastname"),
            @Mapping(source = "document", target = "document"),
            @Mapping(source = "email", target = "email"),
            @Mapping(target = "experienceYears", source = "experienceYears"),
            @Mapping(source = "changeResidence", target = "changeResidence"),
            @Mapping(source = "dateBirth", target = "dateBirth"),
            @Mapping(source = "address", target = "address"),
            @Mapping(source = "age", target = "age"),
    })
    UserProfile toUserProfile(UserProfileDAO dao);

    List<UserProfile> toUserProfiles(List<UserProfileDAO> daos);

    @InheritInverseConfiguration
    UserProfileDAO toUserProfileDAO(UserProfile userProfile);

    @InheritInverseConfiguration
    @Mapping(target = "idWorkExperience",ignore = true )
    WorkExperienceDAO toWorkExperienceDAO(WorkExperience workExperience);

    @InheritInverseConfiguration
    @Mapping(target = "idAcademicBackground",ignore = true )
    AcademicBackgroundDAO toAcademicBackgroundDAO(AcademicBackground academicBackground);

    @InheritInverseConfiguration
    @Mapping(target = "idCertification",ignore = true )
    CertificationDAO toCertificationDAO(Certification certification);
}
