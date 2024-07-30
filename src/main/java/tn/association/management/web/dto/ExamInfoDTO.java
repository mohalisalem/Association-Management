package tn.association.management.web.dto;

import java.time.LocalDateTime;

public record ExamInfoDTO(Long id, String examTitle, LocalDateTime date, Integer duration, String includedLessons,
                          SubjectDTO subject) {
}
