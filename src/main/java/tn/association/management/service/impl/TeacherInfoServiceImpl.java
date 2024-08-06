package tn.association.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import tn.association.management.persistence.dao.TeacherInfoRepository;
import tn.association.management.persistence.model.TeacherInfo;
import tn.association.management.service.TeacherInfoService;
import tn.association.management.web.dto.TeacherInfoDTO;
import tn.association.management.web.dto.mapper.TeacherInfoMapper;
import tn.association.management.web.exception.EntityNotFoundException;
import tn.association.management.web.exception.NullAttributeException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class TeacherInfoServiceImpl implements TeacherInfoService {

    @Autowired
    private TeacherInfoRepository teacherInfoRepository;

    @Autowired
    private TeacherInfoMapper teacherInfoMapper;

    @Override
    public TeacherInfoDTO getTeacherInfoById(Long id) {
        return teacherInfoMapper.convertToDTO(getByIdWithoutConvert(id));
    }

    @Override
    public TeacherInfoDTO addTeacherInfo(String name, String lastName, String phoneNumber, String subjectsAbleToTeach) {
        TeacherInfo teacherInfo = new TeacherInfo(name, lastName, phoneNumber);
        teacherInfo.setSubjectsAbleToTeach(subjectsAbleToTeach);
        return teacherInfoMapper.convertToDTO(teacherInfoRepository.save(teacherInfo));
    }

    @Override
    public TeacherInfoDTO editTeacherInfo(Long id, String name, String lastName, String phoneNumber,
                                          String subjectsAbleToTeach) {
        if (name == null || lastName == null || phoneNumber == null) {
            throw new NullAttributeException(" the given parameters can't be null.");
        }
        TeacherInfo teacherInfo = getByIdWithoutConvert(id);
        teacherInfo.setName(name);
        teacherInfo.setLastName(lastName);
        teacherInfo.setLastName(phoneNumber);
        teacherInfo.setSubjectsAbleToTeach(subjectsAbleToTeach);
        return teacherInfoMapper.convertToDTO(teacherInfoRepository.save(teacherInfo));
    }

    @Override
    public void deleteTeacherInfo(Long id) {
        if (id == null) {
            throw new NullAttributeException("The id must be not null");
        }
        teacherInfoRepository.deleteById(id);
    }

    @Override
    public List<TeacherInfoDTO> getAllTeacherInfos() {
        return StreamSupport.stream(teacherInfoRepository.findAll().spliterator(), false)
                .map(teacherInfoMapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public TeacherInfoDTO getTeacherInfoByPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            throw new NullAttributeException("The phoneNumber must be not null");
        }
        return teacherInfoMapper.convertToDTO(teacherInfoRepository.findByPhoneNumber(phoneNumber));
    }

    @Override
    public List<TeacherInfoDTO> getTeachersInfoByName(String name) {
        if (name == null) {
            throw new NullAttributeException("The name must be not null");
        }
        return teacherInfoRepository.findByName(name).stream().map(teacherInfoMapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public TeacherInfoDTO getTeacherInfoByNameAndLastName(String name, String lastName) {
        if (name == null || lastName == null) {
            throw new NullAttributeException("The given parameters must be not null.");
        }
        return teacherInfoMapper.convertToDTO(teacherInfoRepository.findByNameAndLastName(name, lastName));
    }

    private TeacherInfo getByIdWithoutConvert(Long id) {
        if (id == null) {
            throw new NullAttributeException("The id must be not null");
        }
        return teacherInfoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("there is no Teacher info with the given id :" + id));
    }
}
