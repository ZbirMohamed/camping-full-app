package org.example.bookingservice.repository;

import org.example.bookingservice.domain.entities.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookingEntity,Integer> {
}
