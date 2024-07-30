package tn.association.management.persistence.dao;

import org.springframework.data.repository.CrudRepository;
import tn.association.management.persistence.model.Class;

import java.util.List;
import java.util.Optional;

public interface ClassRepository extends CrudRepository<Class, Long> {

    List<Class> findByName(String name);

    List<Class> findByYear(Integer year);

    Optional<Class> findByNameAndYear(String name, Integer year);
}
