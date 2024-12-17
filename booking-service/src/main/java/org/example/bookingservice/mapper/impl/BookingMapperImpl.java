package org.example.bookingservice.mapper.impl;

import org.example.bookingservice.domain.dto.BookingDto;
import org.example.bookingservice.domain.entities.BookingEntity;
import org.example.bookingservice.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class BookingMapperImpl implements Mapper<BookingEntity, BookingDto> {

    private ModelMapper modelMapper;

    public BookingMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public BookingDto mapTo(BookingEntity bookingEntity) {
        return modelMapper.map(bookingEntity,BookingDto.class);
    }

    @Override
    public BookingEntity mapFrom(BookingDto bookingDto) {
        return modelMapper.map(bookingDto, BookingEntity.class);
    }
}
