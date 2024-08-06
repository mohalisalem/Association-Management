package tn.association.management.web.dto;

import java.util.Set;

public record TeacherDTO(Long id, String year, boolean active, TeacherInfoDTO teacherInfo,
                         Set<Long> teacherAvailabilities, Set<Long> subjectsToTeachByClass) {
}
