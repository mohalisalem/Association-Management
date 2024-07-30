package tn.association.management.persistence.dao;

import org.springframework.data.repository.CrudRepository;
import tn.association.management.persistence.model.StudentAttendance;

import java.time.LocalDate;
import java.util.List;

public interface StudentAttendanceRepository extends CrudRepository<StudentAttendance, Long> {

    List<StudentAttendance> findByDay(LocalDate day);

    List<StudentAttendance> findByStatus(boolean status);

    List<StudentAttendance> findByDayAndStatus(LocalDate day, boolean status);
}
