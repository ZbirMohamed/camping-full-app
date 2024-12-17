package org.example.camp.service.impl;

import org.example.camp.domain.dto.CampDto;
import org.example.camp.domain.entities.CampEntity;
import org.example.camp.mapper.Mapper;
import org.example.camp.repository.CampRepository;
import org.example.camp.service.CampService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CampServiceImpl implements CampService {

    private CampRepository campRepository;
    private Mapper<CampEntity,CampDto> campMapper;

    public CampServiceImpl(CampRepository campRepository,Mapper<CampEntity,CampDto> campMapper) {
        this.campRepository = campRepository;
        this.campMapper = campMapper;
    }

    @Override
    public CampDto save(CampDto camp) {
        CampEntity camp1 = campMapper.mapFrom(camp);
        campRepository.save(camp1);
        return camp;
    }

    @Override
    public List<CampDto> findAll() {
        List<CampEntity> campEntities = campRepository.findAll();
        return campEntities.stream().map(campMapper::mapTo).toList();
    }

    @Override
    public CampDto findCampById(Integer id) {
        CampEntity camp = campRepository.findById(id).orElse(null);
        return campMapper.mapTo(camp);
    }

    @Override
    public boolean isExisting(Integer id) {
        return campRepository.existsById(id);
    }

    @Override
    public void delete(Integer id) {
        campRepository.deleteById(id);
    }
}
