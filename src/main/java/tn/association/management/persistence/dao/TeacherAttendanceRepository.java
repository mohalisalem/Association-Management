package tn.association.management.persistence.dao;

import org.springframework.data.repository.CrudRepository;
import tn.association.management.persistence.model.TeacherAttendance;

import java.time.LocalDate;
import java.util.List;

public interface TeacherAttendanceRepository extends CrudRepository<TeacherAttendance, Long> {

    List<TeacherAttendance> findByDay(LocalDate day);

    List<TeacherAttendance> findByStatus(boolean status);

    List<TeacherAttendance> findByDayAndStatus(LocalDate day, boolean status);
}
