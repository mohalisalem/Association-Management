package tn.association.management.service;

import tn.association.management.persistence.model.TeacherInfo;
import tn.association.management.web.dto.TeacherInfoDTO;

import java.util.List;

public interface TeacherInfoService {

    TeacherInfoDTO getTeacherInfoById(Long id);

    TeacherInfoDTO addTeacherInfo(String name, String lastName, String phoneNumber, String subjectsAbleToTeach);

    TeacherInfoDTO editTeacherInfo(Long id, String name, String lastName, String phoneNumber, String subjectsAbleToTeach);

    void deleteTeacherInfo(Long id);

    List<TeacherInfoDTO> getAllTeacherInfos();

    TeacherInfoDTO getTeacherInfoByPhoneNumber(String phoneNumber);

    List<TeacherInfoDTO> getTeachersInfoByName(String name);

    TeacherInfoDTO getTeacherInfoByNameAndLastName(String name, String lastName);
}
