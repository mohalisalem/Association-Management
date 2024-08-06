package tn.association.management.service;

import tn.association.management.web.dto.LevelDTO;

import java.util.List;

public interface LevelService {

    LevelDTO getLevelById(Long id);

    LevelDTO addLevel(String name, String category);

    LevelDTO editLevel(Long id, String name, String category);

    void deleteLevel(Long id);

    List<LevelDTO> getAllLevels();

}
