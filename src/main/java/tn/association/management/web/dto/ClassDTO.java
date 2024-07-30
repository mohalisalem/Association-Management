package tn.association.management.web.dto;

import java.util.Set;

public record ClassDTO(Long id, String name, Integer year, LevelDTO level, Set<Long> classStudents,
                       Set<Long> classSubjects) {
}
