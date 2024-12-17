package org.example.bookingservice.domain.dto;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class BookingDto {

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
