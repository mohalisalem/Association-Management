package tn.association.management.persistence.dao;

import org.springframework.data.repository.CrudRepository;
import tn.association.management.persistence.model.Subject;

import java.util.List;

public interface SubjectRepository extends CrudRepository<Subject, Long> {

    List<Subject> findBySubjectName(String subjectName);
}
