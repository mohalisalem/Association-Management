package tn.association.management.persistence.dao;

import org.springframework.data.repository.CrudRepository;
import tn.association.management.persistence.model.StudentScore;

import java.util.List;

public interface StudentScoreRepository extends CrudRepository<StudentScore, Long> {

    List<StudentScore> findByExamTitle(String examTitle);

    List<StudentScore> findByScore(Integer score);

    List<StudentScore> findByExamTitleAndScore(String examTitle, Integer score);
}
