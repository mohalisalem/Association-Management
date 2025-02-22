package tn.association.management.web.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tn.association.management.persistence.model.StudentInfo;
import tn.association.management.web.dto.StudentInfoDTO;

@Mapper(componentModel = "spring")
public interface StudentInfoMapper {

    StudentInfoMapper INSTANCE = Mappers.getMapper(StudentInfoMapper.class);

    @Mapping(target = "studentHistory", ignore = true)
    StudentInfo convertToEntity(StudentInfoDTO studentInfoDTO);

    StudentInfoDTO convertToDTO(StudentInfo studentInfo);
}
