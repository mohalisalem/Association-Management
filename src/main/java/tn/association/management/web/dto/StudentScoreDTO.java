package tn.association.management.web.dto;

public record StudentScoreDTO(Long id, String examTitle, Integer score, StudentDTO student,
                              ClassSubjectDTO classSubject) {
}
