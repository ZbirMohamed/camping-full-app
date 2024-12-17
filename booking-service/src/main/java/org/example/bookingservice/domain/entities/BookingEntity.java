package org.example.bookingservice.domain.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Entity(name = "bookings")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class BookingEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Temporal(TemporalType.DATE)
    private Date date_res;
    @Temporal(TemporalType.DATE)
    private Date date_debut;
    @Temporal(TemporalType.DATE)
    private Date date_fin;
    private Integer user_id;
    private Integer camp_id;
}
