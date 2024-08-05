package tn.association.management.web.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tn.association.management.persistence.model.Availability;
import tn.association.management.persistence.model.Class;
import tn.association.management.persistence.model.ClassSubject;
import tn.association.management.persistence.model.Student;
import tn.association.management.web.dto.AvailabilityDTO;
import tn.association.management.web.dto.ClassDTO;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(uses = {LevelMapper.class}, componentModel = "spring")
public interface ClassMapper {


    ClassMapper INSTANCE = Mappers.getMapper(ClassMapper.class);

    @Mapping(target = "classStudents", ignore = true)
    @Mapping(target = "classSubjects", ignore = true)
    Class convertToEntity(ClassDTO classDTO);

    @Mapping(target = "classStudents", expression = "java(convertClassStudentsToIds(aClass.getClassStudents()))")
    @Mapping(target = "classSubjects", expression = "java(convertClassSubjectsToIds(aClass.getClassSubjects()))")
    ClassDTO convertToDTO(Class aClass);

    default Long convertStudentToId(Student student){
        return student != null ? student.getId(): null;
    }

    default Long convertClassSubjectToId(ClassSubject classSubject){
        return classSubject != null ? classSubject.getId(): null;
    }

    default Set<Long> convertClassStudentsToIds(Set<Student> classStudents){
       return classStudents.stream().map(this::convertStudentToId).collect(Collectors.toSet());
    }

    default Set<Long> convertClassSubjectsToIds(Set<ClassSubject> classSubjects){
        return classSubjects.stream().map(this::convertClassSubjectToId).collect(Collectors.toSet());
    }
}
