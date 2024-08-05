package tn.association.management.web.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tn.association.management.persistence.model.Teacher;
import tn.association.management.persistence.model.TeacherInfo;
import tn.association.management.web.dto.TeacherInfoDTO;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface TeacherInfoMapper {
    TeacherInfoMapper INSTANCE = Mappers.getMapper(TeacherInfoMapper.class);

    @Mapping(target = "teacherHistory", ignore = true)
    TeacherInfo convertToEntity(TeacherInfoDTO teacherInfoDTO);

    @Mapping(target = "teacherHistory", expression = "java(convertTeacherToIds(teacherInfo.getTeacherHistory()))")
    TeacherInfoDTO convertToDTO(TeacherInfo teacherInfo);


    default Long getTeacherId(Teacher teacher) {
        return teacher != null ? teacher.getId() : null;
    }

    default Set<Long> convertTeacherToIds(Set<Teacher> teachers) {
        return teachers.stream().map(this::getTeacherId).collect(Collectors.toSet());
    }
}
