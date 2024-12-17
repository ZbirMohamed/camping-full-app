package org.example.camp.domain.dto;


import lombok.*;


//Il y'a une erreur bizzare lors de l'insertion des valeur si l'id = 0 il n'est pas pris comme null est n'est pas inserer au niveau de bdd
@AllArgsConstructor
@NoArgsConstructor @Getter @Setter @ToString
public class CreateCampDto {

    private String campName;
    private Boolean isavailable;
    private Integer price;
    private String description;
    private String images;
    private Integer numberOfSpots;
}
