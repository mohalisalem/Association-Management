package tn.association.management.web.dto;

import java.time.DayOfWeek;
import java.time.LocalTime;

public record AvailabilityDTO(Long id, DayOfWeek day, LocalTime startTime, LocalTime endTime, Boolean inUse,
                              TeacherDTO teacher) {
}
