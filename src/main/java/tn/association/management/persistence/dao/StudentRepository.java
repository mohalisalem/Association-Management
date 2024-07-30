package tn.association.management.persistence.dao;

import org.springframework.data.repository.CrudRepository;
import tn.association.management.persistence.model.Student;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {

    List<Student> findByYear(String year);

    List<Student> findByActive(boolean active);

    List<Student> findByYearAndActive(String year, boolean active);

}
