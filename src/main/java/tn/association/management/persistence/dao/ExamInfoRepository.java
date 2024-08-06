package tn.association.management.persistence.dao;

import org.springframework.data.repository.CrudRepository;
import tn.association.management.persistence.model.ExamInfo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ExamInfoRepository extends CrudRepository<ExamInfo, Long> {

    List<ExamInfo> findByDate(LocalDateTime date);

    List<ExamInfo> findByDuration(Integer duration);

    List<ExamInfo> findByIncludedLessons(String includedLessons);

    List<ExamInfo> findByExamTitle(String examTitle);

    List<ExamInfo> findBySubject_id(Long subjectId);

    Optional<ExamInfo> findByExamTitleAndDate(String examTitle, LocalDateTime date);

}
