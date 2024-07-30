package tn.association.management.persistence.dao;

import org.springframework.data.repository.CrudRepository;
import tn.association.management.persistence.model.Availability;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AvailabilityRepository  extends CrudRepository<Availability, Long> {

    List<Availability> findByDay(String day);

    List<Availability> findByStartTime(LocalDate startTime);

    List<Availability> findByEndTime(LocalDate endTime);

    List<Availability> findByStartTimeAndEndTime(LocalDate startTime, LocalDate endTime);

    Optional<Availability> findByDayAndStartTimeAndEndTime(String day, LocalDate startTime, LocalDate endTime);

    List<Availability> findByTeacher_id(Long teacherId);
}
