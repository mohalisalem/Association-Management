package tn.association.management.web.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import tn.association.management.persistence.model.ExamInfo;
import tn.association.management.web.dto.ExamInfoDTO;

@Mapper(uses = {SubjectMapper.class}, componentModel = "spring")
public interface ExamInfoMapper {

    ExamInfoMapper INSTANCE = Mappers.getMapper(ExamInfoMapper.class);

    ExamInfo convertToEntity(ExamInfoDTO examInfoDTO);

    ExamInfoDTO convertToDTO(ExamInfo examInfo);
}
