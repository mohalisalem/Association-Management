package tn.association.management.persistence.dao;

import org.springframework.data.repository.CrudRepository;
import tn.association.management.persistence.model.Teacher;

import java.util.List;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {

    List<Teacher> findByYear(String year);

    List<Teacher> findByActive(boolean active);

    List<Teacher> findByYearAndActive(String year, boolean active);
}
