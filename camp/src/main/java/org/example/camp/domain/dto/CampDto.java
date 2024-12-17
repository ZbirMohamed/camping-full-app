package org.example.camp.domain.dto;


import lombok.*;


//je sais pas mais il y'a une erreur bizzare avec lombok
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class CampDto {

    private Integer id;
    private String campName;
    private Boolean isavailable;
    private Integer price;
    private String description;
    private String images;
    private Integer numberOfSpots;


}
