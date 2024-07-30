package tn.association.management.web.dto;

import java.util.Set;

public record LevelDTO(Long id, String name, String category, Set<SubjectInfoDTO> subjectInfos,
                       Set<Long> relatedClasses) {
}
