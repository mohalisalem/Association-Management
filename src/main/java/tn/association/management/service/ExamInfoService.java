package tn.association.management.service;

import tn.association.management.persistence.model.Subject;
import tn.association.management.web.dto.ExamInfoDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface ExamInfoService {

    ExamInfoDTO getExamInfoById(Long id);

    ExamInfoDTO addExamInfo(String examTitle, LocalDateTime date, Integer duration, String includedLessons);

    ExamInfoDTO linkExamInfoWithSubject(Long examInfoId, Subject subject);

    ExamInfoDTO editExamInfo(Long id, String examTitle, LocalDateTime date,
                             Integer duration, String includedLessons, Subject subject);

    void deleteExamInfo(Long id);

    List<ExamInfoDTO> getAllExamInfos();

    List<ExamInfoDTO> getExamInfosByDate(LocalDateTime date);

    List<ExamInfoDTO> getExamInfosByDuration(Integer duration);

    List<ExamInfoDTO> getExamInfosBySubject(Long subjectId);
}
