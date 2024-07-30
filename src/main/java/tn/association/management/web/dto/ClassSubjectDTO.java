package tn.association.management.web.dto;

import java.time.DayOfWeek;
import java.time.LocalTime;

public record ClassSubjectDTO(Long id, DayOfWeek day, LocalTime startSession, TeacherDTO teacher, SubjectDTO subject,
                              ClassDTO aClass) {
}
