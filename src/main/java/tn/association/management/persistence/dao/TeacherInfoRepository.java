package tn.association.management.persistence.dao;

import org.springframework.data.repository.CrudRepository;
import tn.association.management.persistence.model.TeacherInfo;

import java.util.List;
import java.util.Optional;

public interface TeacherInfoRepository extends CrudRepository<TeacherInfo, Long> {

    List<TeacherInfo> findByName(String name);

    List<TeacherInfo> findByLastName(String lastName);

    TeacherInfo findByPhoneNumber(String phoneNumber);

    List<TeacherInfo> findBySubjectsAbleToTeach(String subjectsAbleToTeach);

    TeacherInfo findByNameAndLastName(String name, String lastName);

}
