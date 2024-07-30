package tn.association.management.persistence.dao;

import org.springframework.data.repository.CrudRepository;
import tn.association.management.persistence.model.StudentInfo;

import java.time.LocalDate;
import java.util.List;

public interface StudentInfoRepository extends CrudRepository<StudentInfo, Long> {

    List<StudentInfo> findByName(String name);

    List<StudentInfo> findByLastName(String lastName);

    List<StudentInfo> findByBirthDate(LocalDate birthDate);

    List<StudentInfo> findByPhoneNumber(String phoneNumber);

    List<StudentInfo> findByEducationLevel(String educationLevel);

    List<StudentInfo> findByNameAndLastNameAndBirthDate(String name, String lastName, LocalDate birthDate);
}
