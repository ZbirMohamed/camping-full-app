package org.example.camp.service;

import org.example.camp.domain.dto.CampDto;
import org.example.camp.domain.dto.CreateCampDto;

import java.util.List;
import java.util.Optional;

public interface CampService {

    CampDto save(CampDto camp);
    List<CampDto> findAll();
    CampDto findCampById(Integer id);
    boolean isExisting(Integer id);
    void delete(Integer id);
}
