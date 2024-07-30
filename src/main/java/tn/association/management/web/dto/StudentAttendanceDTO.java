package tn.association.management.web.dto;

import java.time.LocalDate;

public record StudentAttendanceDTO(Long id, LocalDate day, boolean status, StudentDTO student,
                                   ClassSubjectDTO classSubject) {
}
