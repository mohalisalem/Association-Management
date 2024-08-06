package tn.association.management.web.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tn.association.management.persistence.model.Student;
import tn.association.management.web.dto.StudentDTO;

@Mapper(uses = {StudentInfoMapper.class, ClassMapper.class}, componentModel = "spring")
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(target = "studentAttendances", ignore = true)
    @Mapping(target = "studentScores", ignore = true)
    @Mapping(target = "AClass", source = "aClass")
    Student convertToEntity(StudentDTO studentDTO);

    @Mapping(target = "aClass", source = "AClass")
    StudentDTO convertToDTO(Student student);
}
