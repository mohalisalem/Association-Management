package tn.association.management.persistence.dao;

import org.springframework.data.repository.CrudRepository;
import tn.association.management.persistence.model.Availability;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

public interface AvailabilityRepository extends CrudRepository<Availability, Long> {

    List<Availability> findByDay(DayOfWeek day);

    List<Availability> findByStartTime(LocalTime startTime);

    List<Availability> findByEndTime(LocalTime endTime);

    List<Availability> findByInUse(Boolean inUse);

    List<Availability> findByStartTimeAndEndTime(LocalTime startTime, LocalTime endTime);

    List<Availability> findByDayAndStartTimeAndEndTime(DayOfWeek day, LocalTime startTime, LocalTime endTime);

    List<Availability> findByDayAndStartTimeAndEndTimeAndInUse(DayOfWeek day, LocalTime startTime, LocalTime endTime, Boolean inUse);

    List<Availability> findByTeacher_id(Long teacherId);

    Availability findByTeacher_idAndDayAndStartTimeAndEndTime(Long teacherId, DayOfWeek day, LocalTime startTime, LocalTime endTime);

    List<Availability> findByTeacher_idAndDay(Long teacherId, DayOfWeek day);
}
