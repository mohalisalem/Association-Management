package tn.association.management.web.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import tn.association.management.persistence.model.Student;
import tn.association.management.persistence.model.StudentAttendance;
import tn.association.management.web.dto.StudentAttendanceDTO;

@Mapper(uses = {StudentMapper.class, ClassSubjectMapper.class}, componentModel = "spring")
public interface StudentAttendanceMapper {

    StudentAttendanceMapper INSTANCE = Mappers.getMapper(StudentAttendanceMapper.class);

    StudentAttendance convertToEntity(StudentAttendanceDTO studentAttendanceDTO);

    StudentAttendanceDTO convertToDTO(StudentAttendance studentAttendance);
}
