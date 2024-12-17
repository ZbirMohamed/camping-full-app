package org.example.bookingservice.service;

import org.example.bookingservice.domain.dto.BookingDto;
import org.example.bookingservice.domain.entities.BookingEntity;

import java.util.List;

public interface BookingService {

    BookingDto save(BookingDto bookingDto);
    List<BookingDto> getAllBookings();

    BookingDto getBookingById(Integer id);

    boolean isExisting(Integer id);

    void delete(Integer id);


}
