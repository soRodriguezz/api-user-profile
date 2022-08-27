package com.pch.apiuserprofile.persistence.mappers;

import com.pch.apiuserprofile.domain.entities.AcademicBackground;
import com.pch.apiuserprofile.persistence.models.AcademicBackgroundDAO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring",uses = {UserProfileMapper.class})
public interface AcademicBackgroundMapper {

    @Mappings({
            @Mapping(source = "idAcademicBackground",target = "idAcademicBackground"),
            @Mapping(source = "school",target = "school"),
            @Mapping(source = "degree",target = "degree"),
            @Mapping(source = "startMonth",target = "startMonth"),
            @Mapping(source = "endMonth",target = "endMonth"),
            @Mapping(source = "startYear",target = "startYear"),
            @Mapping(source = "endYear",target = "endYear"),
            @Mapping(source = "grade",target = "grade"),
            @Mapping(source = "description",target = "description"),
            @Mapping(source = "userProfile",target = "userProfile"),
    })
    AcademicBackground toAcademicBackground(AcademicBackgroundDAO dao);

    List<AcademicBackground> toAcademicBackgrounds(List<AcademicBackgroundDAO> daos);

    @InheritInverseConfiguration
    AcademicBackgroundDAO toAcademicBackgroundDAO(AcademicBackground academicBackground);
}
