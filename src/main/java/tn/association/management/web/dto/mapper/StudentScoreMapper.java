package tn.association.management.web.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import tn.association.management.persistence.model.StudentScore;
import tn.association.management.web.dto.StudentScoreDTO;

@Mapper(uses = {StudentMapper.class, ClassSubjectMapper.class}, componentModel = "spring")
public interface StudentScoreMapper {

    StudentScoreMapper INSTANCE = Mappers.getMapper(StudentScoreMapper.class);

    StudentScore convertToEntity(StudentScoreDTO studentScoreDTO);

    StudentScoreDTO convertToDTO(StudentScore studentScore);
}
