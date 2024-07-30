package tn.association.management.web.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tn.association.management.persistence.model.SubjectInfo;
import tn.association.management.web.dto.SubjectInfoDTO;

@Mapper(componentModel = "spring")
public interface SubjectInfoMapper {

    SubjectInfoMapper INSTANCE = Mappers.getMapper(SubjectInfoMapper.class);

    SubjectInfo convertToEntity(SubjectInfoDTO subjectInfoDTO);

    @Mapping(target = "levelId", source = "level.id")
    SubjectInfoDTO convertToDTO(SubjectInfo subjectInfo);
}
