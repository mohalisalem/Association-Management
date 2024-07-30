package tn.association.management.web.dto;

public record StudentDTO(Long id, String year, boolean active, StudentInfoDTO studentInfo, ClassDTO aClass) {
}
