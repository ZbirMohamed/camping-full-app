package org.example.camp.mapper.impl;

import org.example.camp.domain.dto.CampDto;
import org.example.camp.domain.entities.CampEntity;
import org.example.camp.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CampMapperImpl implements Mapper<CampEntity, CampDto> {

    private ModelMapper modelMapper;

    public CampMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CampDto mapTo(CampEntity campEntity) {
        return modelMapper.map(campEntity, CampDto.class);
    }

    @Override
    public CampEntity mapFrom(CampDto campDto) {
        return modelMapper.map(campDto, CampEntity.class);
    }


}
