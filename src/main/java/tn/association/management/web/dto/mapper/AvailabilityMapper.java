package tn.association.management.web.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import tn.association.management.persistence.model.Availability;
import tn.association.management.web.dto.AvailabilityDTO;

@Mapper(uses = {TeacherMapper.class}, componentModel = "spring")
public interface AvailabilityMapper {

    AvailabilityMapper INSTANCE = Mappers.getMapper(AvailabilityMapper.class);

    Availability convertToEntity(AvailabilityDTO availabilityDTO);

    AvailabilityDTO convertToDTO(Availability availability);
}
