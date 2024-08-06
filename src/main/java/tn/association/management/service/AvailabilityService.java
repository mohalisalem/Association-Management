package tn.association.management.service;

import tn.association.management.persistence.model.Teacher;
import tn.association.management.web.dto.AvailabilityDTO;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

public interface AvailabilityService {

    AvailabilityDTO getAvailabilityById(Long id);

    AvailabilityDTO addAvailability(DayOfWeek day, LocalTime startTime, LocalTime endTime);

    AvailabilityDTO linkAvailabilityToTeacher(Long availabilityId, Teacher teacher);

    AvailabilityDTO reserveAvailability(Long availabilityId);

    AvailabilityDTO reservePartOfAvailability(Long availabilityId, LocalTime startTime, LocalTime endTime);

    AvailabilityDTO editAvailability(Long availabilityId, DayOfWeek day, LocalTime startTime, LocalTime endTime, Boolean inUse, Teacher teacher);

    void deleteAvailability(Long availabilityId);

    List<AvailabilityDTO> getAllAvailabilities();

    List<AvailabilityDTO> getAllTeacherAvailabilities(Long teacherId);

    List<AvailabilityDTO> getAvailabilitiesByDay(DayOfWeek day);

    List<AvailabilityDTO> getAvailabilitiesByDayAndStartTimeAndEndTime(DayOfWeek day, LocalTime startTime, LocalTime endTime);

    AvailabilityDTO getTeacherAvailability(Long teacherId, DayOfWeek day, LocalTime startTime, LocalTime endTime);

    List<AvailabilityDTO> getTeacherAvailabilitiesByDay(Long teacherId, DayOfWeek day);

}
