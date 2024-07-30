package tn.association.management.web.dto;

import java.util.Set;

public record TeacherInfoDTO(Long id, String name, String lastName, String phoneNumber, String subjectsAbleToTeach,
                             Set<Long> teacherHistory) {
}
