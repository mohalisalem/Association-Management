package tn.association.management.web.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tn.association.management.persistence.model.Availability;
import tn.association.management.persistence.model.ClassSubject;
import tn.association.management.web.dto.AvailabilityDTO;
import tn.association.management.web.dto.ClassSubjectDTO;

@Mapper(uses = {TeacherMapper.class, SubjectMapper.class, ClassMapper.class}, componentModel = "spring")
public interface ClassSubjectMapper {

    ClassSubjectMapper INSTANCE = Mappers.getMapper(ClassSubjectMapper.class);

    @Mapping(target = "teacherAttendances", ignore = true)
    @Mapping(target = "studentAttendances", ignore = true)
    @Mapping(target = "studentExamScores", ignore = true)
    ClassSubject convertToEntity(ClassSubjectDTO classSubjectDTO);

    ClassSubjectDTO convertToDTO(ClassSubject classSubject);
}
