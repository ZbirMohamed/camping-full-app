package org.example.bookingservice.service.impl;

import org.example.bookingservice.domain.dto.BookingDto;
import org.example.bookingservice.domain.entities.BookingEntity;
import org.example.bookingservice.mapper.Mapper;
import org.example.bookingservice.repository.BookingRepository;
import org.example.bookingservice.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class BookingServiceImpl implements BookingService {

    BookingRepository bookingRepository;

    Mapper<BookingEntity,BookingDto> bookingMapper;

    public BookingServiceImpl(BookingRepository bookingRepository, Mapper<BookingEntity,BookingDto> bookingMapper) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
    }

    @Override
    public BookingDto save(BookingDto bookingDto) {
        BookingEntity bookingDto1 = bookingMapper.mapFrom(bookingDto);
        bookingRepository.save(bookingDto1);
        return bookingDto;
    }

    @Override
    public List<BookingDto> getAllBookings() {
        List<BookingEntity> books = bookingRepository.findAll();
        return  books.stream().map(bookingMapper::mapTo).toList();
    }

    @Override
    public BookingDto getBookingById(Integer id) {
        BookingEntity booking = bookingRepository.findById(id).orElse(null);
        return bookingMapper.mapTo(booking);
    }

    @Override
    public boolean isExisting(Integer id) {
        return bookingRepository.existsById(id);
    }

    @Override
    public void delete(Integer id) {
        bookingRepository.deleteById(id);
    }
}
