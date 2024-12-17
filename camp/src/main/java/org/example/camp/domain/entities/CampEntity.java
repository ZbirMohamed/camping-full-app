package org.example.camp.domain.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;


//lombok bizzarement ne marche pas je ss pas pourquoi
@Entity(name = "camp")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString@Builder
public class CampEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String campName;
    private Boolean isavailable;
    private Integer price;
    private String description;
    private String images;
    private Integer numberOfSpots;


}
