package tn.association.management.web.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tn.association.management.persistence.model.Class;
import tn.association.management.persistence.model.Level;
import tn.association.management.web.dto.LevelDTO;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(uses = {SubjectInfoMapper.class}, componentModel = "spring")
public interface LevelMapper {

    LevelMapper INSTANCE = Mappers.getMapper(LevelMapper.class);

    @Mapping(target = "relatedClasses", ignore = true)
    Level convertToEntity(LevelDTO levelDTO);

    @Mapping(target = "relatedClasses", expression="java(convertClassToIds(level.getRelatedClasses()))")
    LevelDTO convertToDTO(Level level);


    default Long getId(Class aClass) {
        return aClass != null ? aClass.getId() : null;
    }

    default Set<Long> convertClassToIds(Set<Class> relatedClasses) {
        return relatedClasses.stream()
                .map(this::getId)
                .collect(Collectors.toSet());
    }
}
