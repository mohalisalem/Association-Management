package tn.association.management.web.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tn.association.management.persistence.model.Availability;
import tn.association.management.persistence.model.ClassSubject;
import tn.association.management.persistence.model.Teacher;
import tn.association.management.web.dto.TeacherDTO;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(uses = {TeacherAttendanceMapper.class}, componentModel = "spring")
public interface TeacherMapper {
    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    @Mapping(target = "teacherAvailabilities", ignore = true)
    @Mapping(target = "subjectsToTeachByClass", ignore = true)
    Teacher convertToEntity(TeacherDTO teacherDTO);

    @Mapping(target = "teacherAvailabilities", expression = "java(convertAvailabilityToIds(teacher.getTeacherAvailabilities()))")
    @Mapping(target = "subjectsToTeachByClass", expression = "java(convertClassSubjectToIds(teacher.getSubjectsToTeachByClass()))")
    TeacherDTO convertToDTO(Teacher teacher);


    default Long getAvailabilityId(Availability availability) {
        return availability != null ? availability.getId() : null;
    }

    default Long getClassSubjectId(ClassSubject classSubject) {
        return classSubject != null ? classSubject.getId() : null;
    }

    default Set<Long> convertAvailabilityToIds(Set<Availability> availabilities) {
        return availabilities.stream().map(this::getAvailabilityId).collect(Collectors.toSet());
    }

    default Set<Long> convertClassSubjectToIds(Set<ClassSubject> classSubjects) {
        return classSubjects.stream().map(this::getClassSubjectId).collect(Collectors.toSet());
    }
}
