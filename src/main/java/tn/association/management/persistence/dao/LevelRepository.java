package tn.association.management.persistence.dao;

import org.springframework.data.repository.CrudRepository;
import tn.association.management.persistence.model.Level;

import java.util.List;
import java.util.Optional;

public interface LevelRepository extends CrudRepository<Level, Long> {

    List<Level> findByName(String name);

    List<Level> findByCategory(String category);

    Optional<Level> findByNameAndCategory(String name, String category);

}
