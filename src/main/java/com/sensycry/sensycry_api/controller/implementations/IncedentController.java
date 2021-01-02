package com.sensycry.sensycry_api.controller.implementations;

import com.sensycry.sensycry_api.controller.ControllerWithDto;
import com.sensycry.sensycry_api.domain.Incedent;
import com.sensycry.sensycry_api.dto.IncedentDto;
import com.sensycry.sensycry_api.service.implementation.IncedentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
public class IncedentController implements ControllerWithDto<IncedentDto, Incedent> {
    private final IncedentService incedentService;
    
    public IncedentController(
        IncedentService incedentService) {
        this.incedentService = incedentService;
    }
    
    @GetMapping(value = "/sensycry/incedent/all")
    public ResponseEntity<List<IncedentDto>> getIncedents() {
        List<Incedent> incedents = incedentService.getEntities();
        List<IncedentDto> incedentsDto = createDtos(incedents);
        return new ResponseEntity<>(incedentsDto, HttpStatus.OK);
    }
    
    @GetMapping(value = "/sensycry/incedent/all/{count}")
    public ResponseEntity<List<IncedentDto>> getIncedentsByLimit(@PathVariable Integer count) {
        List<Incedent> incedents = incedentService.getIncedentWithLimit(count);
        List<IncedentDto> incedentsDto = createDtos(incedents);
        return new ResponseEntity<>(incedentsDto, HttpStatus.OK);
    }
    
    @GetMapping(value = "/sensycry/incedent/{id}")
    public ResponseEntity<IncedentDto> getIncedent(@PathVariable Integer id) {
        Incedent incedent = incedentService.getEntity(id);
        IncedentDto incedentDto = createDto(incedent);
        return new ResponseEntity<>(incedentDto, HttpStatus.OK);
    }
    
    @PostMapping(value = "/sensycry/incedent")
    public ResponseEntity<IncedentDto> setIncedent(@RequestBody Incedent incedent) {
        Incedent newIncedent = incedentService.createEntity(incedent);
        IncedentDto incedentDto = createDto(newIncedent);
        return new ResponseEntity<>(incedentDto, HttpStatus.OK);
    }
    
    @PutMapping(value = "/sensycry/incedent/{id}")
    public ResponseEntity<IncedentDto> updateIncedent(
        @RequestBody Incedent incedent, @PathVariable Integer id) {
        Incedent newIncedent = incedentService.updateEntity(incedent, id);
        IncedentDto incedentDto = createDto(newIncedent);
        return new ResponseEntity<>(incedentDto, HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/sensycry/incedent/{id}")
    public ResponseEntity<IncedentDto> deleteIncedent(@PathVariable Integer id) {
        Incedent oldIncedent = incedentService.deleteEntity(id);
        IncedentDto incedentDto = createDto(oldIncedent);
        return new ResponseEntity<>(incedentDto, HttpStatus.OK);
    }
    
    @GetMapping(value = "/sensycry/incedent/apartment/{id}")
    public ResponseEntity<List<IncedentDto>> getIncedentsByApartment(@PathVariable Integer id) {
        Set<Incedent> incedents = incedentService.getIncedentByApartment(id);
        List<IncedentDto> incedentsDto = createDtos(incedents);
        return new ResponseEntity<>(incedentsDto, HttpStatus.OK);
    }
    
    @Override
    public List<IncedentDto> createDtos(Iterable<Incedent> incedents) {
        List<IncedentDto> incedentsDto = new ArrayList<>();
        for (Incedent incedent : incedents) {
            IncedentDto incedentDto = new IncedentDto(incedent);
            incedentsDto.add(incedentDto);
        }
        
        return incedentsDto;
    }
    
    @Override
    public IncedentDto createDto(Incedent incedent) {
        return new IncedentDto(incedent);
    }
}
