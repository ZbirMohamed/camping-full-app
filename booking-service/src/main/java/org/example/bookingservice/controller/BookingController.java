package org.example.bookingservice.controller;


import org.example.bookingservice.domain.dto.BookingDto;
import org.example.bookingservice.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public ResponseEntity<List<BookingDto>> getAllBooking(){
        List<BookingDto> books = bookingService.getAllBookings();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDto> getBookingById(@PathVariable Integer id){
        if(!bookingService.isExisting(id)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        BookingDto bookingDto = bookingService.getBookingById(id);

        return new ResponseEntity<>(bookingDto,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookingDto> addBooking(@RequestBody BookingDto bookingDto){
        bookingDto.setId(null);
        bookingService.save(bookingDto);
        return new ResponseEntity<>(bookingDto,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookingDto> updateBooking(@PathVariable Integer id, @RequestBody BookingDto bookingDto){
        if(!bookingService.isExisting(id)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        bookingDto.setId(id);
        bookingService.save(bookingDto);

        return new ResponseEntity<>(bookingDto,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Integer id){
        if(!bookingService.isExisting(id)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        bookingService.delete(id);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
