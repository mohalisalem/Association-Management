package tn.association.management.web.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import tn.association.management.persistence.model.TeacherAttendance;
import tn.association.management.web.dto.TeacherAttendanceDTO;

@Mapper(uses = {ClassSubjectMapper.class}, componentModel = "spring")
public interface TeacherAttendanceMapper {
    TeacherAttendanceMapper INSTANCE = Mappers.getMapper(TeacherAttendanceMapper.class);

    TeacherAttendance convertToEntity(TeacherAttendanceDTO teacherAttendanceDTO);

    TeacherAttendanceDTO convertToDTO(TeacherAttendance teacherAttendance);
}
