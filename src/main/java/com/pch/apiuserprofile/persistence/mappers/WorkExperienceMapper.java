package com.pch.apiuserprofile.persistence.mappers;

import com.pch.apiuserprofile.domain.entities.WorkExperience;
import com.pch.apiuserprofile.persistence.models.WorkExperienceDAO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring",uses = {UserProfileMapper.class})
public interface WorkExperienceMapper {

    @Mappings({
            @Mapping(source = "idWorkExperience",target = "idWorkExperience"),
            @Mapping(source = "title",target = "title"),
            @Mapping(source = "employmentType",target = "employmentType"),
            @Mapping(source = "companyName",target = "companyName"),
            @Mapping(source = "location",target = "location"),
            @Mapping(source = "startMonth",target = "startMonth"),
            @Mapping(source = "endMonth",target = "endMonth"),
            @Mapping(source = "startYear",target = "startYear"),
            @Mapping(source = "endYear",target = "endYear"),
            @Mapping(source = "description",target = "description"),
            @Mapping(source = "userProfile",target = "userProfile"),
    })
    WorkExperience toWorkExperience(WorkExperienceDAO dao);

    List<WorkExperience> toWorkExperiences(List<WorkExperienceDAO> daos);

    @InheritInverseConfiguration
    WorkExperienceDAO toWorkExperienceDAO(WorkExperience workExperience);
}
