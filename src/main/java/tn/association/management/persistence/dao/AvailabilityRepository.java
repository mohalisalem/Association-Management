package tn.association.management.persistence.dao;

import org.springframework.data.repository.CrudRepository;
import tn.association.management.persistence.model.Availability;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public interface AvailabilityRepository  extends CrudRepository<Availability, Long> {

    List<Availability> findByDay(DayOfWeek day);

    List<Availability> findByStartTime(LocalDate startTime);

    List<Availability> findByEndTime(LocalDate endTime);

    List<Availability> findByInUse(Boolean inUse);

    List<Availability> findByStartTimeAndEndTime(LocalDate startTime, LocalDate endTime);

    List<Availability> findByDayAndStartTimeAndEndTime(DayOfWeek day, LocalDate startTime, LocalDate endTime);

    List<Availability> findByDayAndStartTimeAndEndTimeAndInUse(DayOfWeek day, LocalDate startTime, LocalDate endTime, Boolean inUse);

    List<Availability> findByTeacher_id(Long teacherId);
}
