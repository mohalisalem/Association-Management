package tn.association.management.web.dto;

import java.util.Set;

public record SubjectDTO(Long id, String subjectName, Set<Long> examsInfos, Set<Long> classSubjects) {
}
