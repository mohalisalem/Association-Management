package tn.association.management.web.dto;

import java.time.LocalDate;

public record TeacherAttendanceDTO(Long id, LocalDate day, boolean status, ClassSubjectDTO classSubject) {
}
