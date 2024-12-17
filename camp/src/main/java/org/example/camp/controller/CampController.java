package org.example.camp.controller;


import org.example.camp.domain.dto.CampDto;
import org.example.camp.service.CampService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/camp")
public class CampController {

    private CampService campService;

    public CampController(CampService campService) {
        this.campService = campService;
    }

    @GetMapping
    public ResponseEntity<List<CampDto>> getAllCamps(){
        List<CampDto> camps = campService.findAll();
        return new ResponseEntity<>(camps, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampDto> getCampById(@PathVariable Integer id){

        if(!campService.isExisting(id)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        CampDto campDto = campService.findCampById(id);

        return new ResponseEntity<>(campDto,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CampDto> addCamp(@RequestBody CampDto campDto){
        //bizzarement le save n'accepte plus le zero alors je vais lui passer une valeur null
        campDto.setId(null);
        campService.save(campDto);
        return new ResponseEntity<>(campDto,HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<CampDto> updateCamp(@PathVariable Integer id, @RequestBody CampDto campDto){
        if(!campService.isExisting(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        campDto.setId(id);

        CampDto updateCamp =campService.save(campDto);
        return new ResponseEntity<>(updateCamp,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCamp(@PathVariable Integer id){
        if(!campService.isExisting(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        campService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
