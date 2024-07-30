package tn.association.management.persistence.dao;

import org.springframework.data.repository.CrudRepository;
import tn.association.management.persistence.model.ExamInfo;

public interface ExamInfoRepository extends CrudRepository<ExamInfo, Long> {
}
