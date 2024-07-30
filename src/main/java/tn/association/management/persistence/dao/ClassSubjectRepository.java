package tn.association.management.persistence.dao;

import org.springframework.data.repository.CrudRepository;
import tn.association.management.persistence.model.ClassSubject;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

public interface ClassSubjectRepository extends CrudRepository<ClassSubject, Long> {

    List<ClassSubject> findByDay(DayOfWeek day);

    List<ClassSubject> findByStartSession(LocalTime startSession);

    List<ClassSubject> findByDayAndStartSession(DayOfWeek day, LocalTime startSession);
}
