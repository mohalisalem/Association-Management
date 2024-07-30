package tn.association.management.web.dto;

public record SubjectInfoDTO(Long id, String subjectName, String mainSource, String sourceAuthor,
                             String subjectDuration, Integer singleSessionDuration, Long levelId) {
}
