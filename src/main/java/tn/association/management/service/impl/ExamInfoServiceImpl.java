package tn.association.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import tn.association.management.persistence.dao.ExamInfoRepository;
import tn.association.management.persistence.model.ExamInfo;
import tn.association.management.persistence.model.Subject;
import tn.association.management.service.ExamInfoService;
import tn.association.management.web.dto.ExamInfoDTO;
import tn.association.management.web.dto.mapper.ExamInfoMapper;
import tn.association.management.web.exception.EntityNotFoundException;
import tn.association.management.web.exception.NullAttributeException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ExamInfoServiceImpl implements ExamInfoService {

    @Autowired
    private ExamInfoRepository examInfoRepository;

    @Autowired
    private ExamInfoMapper examInfoMapper;

    @Override
    public ExamInfoDTO getExamInfoById(Long id) {
        return examInfoMapper.convertToDTO(getByIdWithoutConvert(id));
    }

    @Override
    public ExamInfoDTO addExamInfo(String examTitle, LocalDateTime date, Integer duration, String includedLessons) {
        if (examTitle == null || date == null || duration == null) {
            throw new NullAttributeException("The given parameters can't be null.");
        }
        ExamInfo examInfo = new ExamInfo();
        examInfo.setExamTitle(examTitle);
        examInfo.setDate(date);
        examInfo.setDuration(duration);
        examInfo.setIncludedLessons(includedLessons);
        return examInfoMapper.convertToDTO(examInfoRepository.save(examInfo));
    }

    @Override
    public ExamInfoDTO linkExamInfoWithSubject(Long examInfoId, Subject subject) {
        if (subject == null) {
            throw new NullAttributeException("Subject can't be null.");
        }
        ExamInfo examInfo = getByIdWithoutConvert(examInfoId);
        examInfo.setSubject(subject);
        return examInfoMapper.convertToDTO(examInfoRepository.save(examInfo));
    }

    @Override
    public ExamInfoDTO editExamInfo(Long id, String examTitle, LocalDateTime date, Integer duration,
                                    String includedLessons, Subject subject) {
        if (examTitle == null || date == null || duration == null) {
            throw new NullAttributeException("The given parameters can't be null.");
        }
        ExamInfo examInfo = getByIdWithoutConvert(id);
        examInfo.setExamTitle(examTitle);
        examInfo.setDate(date);
        examInfo.setDuration(duration);
        examInfo.setIncludedLessons(includedLessons);
        if (subject == null) {
            throw new NullAttributeException("Subject can't be null.");
        }
        examInfo.setSubject(subject);
        return examInfoMapper.convertToDTO(examInfoRepository.save(examInfo));
    }

    @Override
    public void deleteExamInfo(Long id) {
        if (id == null) {
            throw new NullAttributeException("The id can't be null.");
        }
        examInfoRepository.deleteById(id);
    }

    @Override
    public List<ExamInfoDTO> getAllExamInfos() {
        return StreamSupport.stream(examInfoRepository.findAll().spliterator(), false)
                .map(examInfoMapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<ExamInfoDTO> getExamInfosByDate(LocalDateTime date) {
        if (date == null) {
            throw new NullAttributeException("The date can't be null.");
        }
        return examInfoRepository.findByDate(date).stream()
                .map(examInfoMapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<ExamInfoDTO> getExamInfosByDuration(Integer duration) {
        if (duration == null) {
            throw new NullAttributeException("The duration can't be null.");
        }
        return examInfoRepository.findByDuration(duration).stream()
                .map(examInfoMapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<ExamInfoDTO> getExamInfosBySubject(Long subjectId) {
        if (subjectId == null) {
            throw new NullAttributeException("The subjectId can't be null.");
        }
        return examInfoRepository.findBySubject_id(subjectId).stream()
                .map(examInfoMapper::convertToDTO).collect(Collectors.toList());
    }

    private ExamInfo getByIdWithoutConvert(Long id) {
        if (id == null) {
            throw new NullAttributeException("The id can't be null.");
        }
        return examInfoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(" there is no Exam info with the given id :" + id));
    }
}
