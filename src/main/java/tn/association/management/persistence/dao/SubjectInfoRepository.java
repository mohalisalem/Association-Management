package tn.association.management.persistence.dao;

import org.springframework.data.repository.CrudRepository;
import tn.association.management.persistence.model.SubjectInfo;

import java.util.List;

public interface SubjectInfoRepository extends CrudRepository<SubjectInfo, Long> {

    List<SubjectInfo> findBySubjectName(String subjectName);

    List<SubjectInfo> findByMainSource(String mainSource);

    List<SubjectInfo> findBySourceAuthor(String sourceAuthor);

    List<SubjectInfo> findBySubjectDuration(String subjectDuration);

    List<SubjectInfo> findBySingleSessionDuration(Integer singleSessionDuration);

    List<SubjectInfo> findBySubjectNameAndMainSource(String subjectName, String mainSource);
}
