package tn.association.management.web.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tn.association.management.persistence.model.ClassSubject;
import tn.association.management.persistence.model.ExamInfo;
import tn.association.management.persistence.model.Subject;
import tn.association.management.web.dto.SubjectDTO;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface SubjectMapper {

    SubjectMapper INSTANCE = Mappers.getMapper(SubjectMapper.class);


    @Mapping(target = "classSubjects", ignore = true)
    @Mapping(target = "examsInfos", ignore = true)
    Subject convertToEntity(SubjectDTO subjectDTO);

    @Mapping(target = "examsInfos", expression = "java(convertExamInfosToIds(subject.getExamsInfos()))")
    @Mapping(target = "classSubjects", expression = "java(convertClassSubjectsToIds(subject.getClassSubjects()))")
    SubjectDTO convertToDTO(Subject subject);


    default Long getExamInfoId(ExamInfo examInfo) {
        return examInfo != null ? examInfo.getId() : null;
    }

    default Long getClassSubjectId(ClassSubject classSubject) {
        return classSubject != null ? classSubject.getId() : null;
    }

    default Set<Long> convertExamInfosToIds(Set<ExamInfo> examInfos) {
        return examInfos.stream().map(this::getExamInfoId).collect(Collectors.toSet());
    }

    default Set<Long> convertClassSubjectsToIds(Set<ClassSubject> classSubjects) {
        return classSubjects.stream().map(this::getClassSubjectId).collect(Collectors.toSet());
    }
}
