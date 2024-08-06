package tn.association.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import tn.association.management.persistence.dao.LevelRepository;
import tn.association.management.persistence.model.Level;
import tn.association.management.service.LevelService;
import tn.association.management.web.dto.LevelDTO;
import tn.association.management.web.dto.mapper.LevelMapper;
import tn.association.management.web.exception.EntityNotFoundException;
import tn.association.management.web.exception.NullAttributeException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class LevelServiceImpl implements LevelService {

    @Autowired
    private LevelMapper levelMapper;

    @Autowired
    private LevelRepository levelRepository;

    @Override
    public LevelDTO getLevelById(Long id) {
        Level level = getByIdWithoutConvert(id);
        return levelMapper.convertToDTO(level);
    }

    @Override
    public LevelDTO addLevel(String name, String category) {
        if(name == null || category == null){
            throw new NullAttributeException("The given parameters can't be null");
        }
        Level level = new Level();
        level.setCategory(category);
        level.setName(name);
        return levelMapper.convertToDTO(levelRepository.save(level));
    }

    @Override
    public LevelDTO editLevel(Long id, String name, String category) {
        if(name == null || category == null){
            throw new NullAttributeException("The given parameters can't be null");
        }
        Level level = getByIdWithoutConvert(id);
        level.setCategory(category);
        level.setName(name);
        return levelMapper.convertToDTO(levelRepository.save(level));
    }

    @Override
    public void deleteLevel(Long id) {
        if (id == null) {
            throw new NullAttributeException("The id must be not null");
        }
        levelRepository.deleteById(id);
    }

    @Override
    public List<LevelDTO> getAllLevels() {
        return StreamSupport.stream(levelRepository.findAll().spliterator(), false)
                .map(levelMapper::convertToDTO).collect(Collectors.toList());
    }

    private Level getByIdWithoutConvert(Long id) {
        if (id == null) {
            throw new NullAttributeException("The id must be not null");
        }
        return levelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(" there is no Availability with the given id :" + id));
    }
}
