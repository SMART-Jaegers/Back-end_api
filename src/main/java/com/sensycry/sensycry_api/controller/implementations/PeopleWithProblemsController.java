package com.sensycry.sensycry_api.controller.implementations;

import com.sensycry.sensycry_api.controller.ControllerWithDto;
import com.sensycry.sensycry_api.domain.PeopleWithProblems;
import com.sensycry.sensycry_api.dto.PeopleWithProblemsDto;
import com.sensycry.sensycry_api.service.implementation.PeopleWithProblemsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PeopleWithProblemsController
    implements ControllerWithDto<PeopleWithProblemsDto, PeopleWithProblems> {
    private final PeopleWithProblemsService peopleWithProblemsService;
    
    public PeopleWithProblemsController(
        PeopleWithProblemsService peopleWithProblemsService) {
        this.peopleWithProblemsService = peopleWithProblemsService;
    }
    
    @GetMapping(value = "/sensycry/peopleWithProblems")
    public ResponseEntity<List<PeopleWithProblemsDto>> getPeopleWithProblemss() {
        List<PeopleWithProblems> peopleWithProblems = peopleWithProblemsService.getEntities();
        List<PeopleWithProblemsDto> peoplesWithProblemsDto = createDtos(peopleWithProblems);
        return new ResponseEntity<>(peoplesWithProblemsDto, HttpStatus.OK);
    }
    
    @GetMapping(value = "/sensycry/peopleWithProblems/{id}")
    public ResponseEntity<PeopleWithProblemsDto> getPeopleWithProblems(@PathVariable Integer id) {
        PeopleWithProblems peopleWithProblems = peopleWithProblemsService.getEntity(id);
        PeopleWithProblemsDto peopleWithProblemsDto = createDto(peopleWithProblems);
        return new ResponseEntity<>(peopleWithProblemsDto, HttpStatus.OK);
    }
    
    @PostMapping(value = "/sensycry/peopleWithProblems")
    public ResponseEntity<PeopleWithProblemsDto> setPeopleWithProblems(
        @RequestBody PeopleWithProblems peopleWithProblems) {
        PeopleWithProblems newPeopleWithProblems =
            peopleWithProblemsService.createEntity(peopleWithProblems);
        PeopleWithProblemsDto peopleWithProblemsDto = createDto(newPeopleWithProblems);
        return new ResponseEntity<>(peopleWithProblemsDto, HttpStatus.OK);
    }
    
    @PutMapping(value = "/sensycry/peopleWithProblems/{id}")
    public ResponseEntity<PeopleWithProblemsDto> updatePeopleWithProblems(
        @RequestBody PeopleWithProblems peopleWithProblems, @PathVariable Integer id) {
        PeopleWithProblems newPeopleWithProblems =
            peopleWithProblemsService.updateEntity(peopleWithProblems, id);
        PeopleWithProblemsDto peopleWithProblemsDto = createDto(newPeopleWithProblems);
        return new ResponseEntity<>(peopleWithProblemsDto, HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/sensycry/peopleWithProblems/{id}")
    public ResponseEntity<PeopleWithProblemsDto> deletePeopleWithProblems(
        @PathVariable Integer id) {
        PeopleWithProblems oldPeopleWithProblems = peopleWithProblemsService.deleteEntity(id);
        PeopleWithProblemsDto peopleWithProblemsDto = createDto(oldPeopleWithProblems);
        return new ResponseEntity<>(peopleWithProblemsDto, HttpStatus.OK);
    }
    
    @Override
    public List<PeopleWithProblemsDto> createDtos(
        Iterable<PeopleWithProblems> peoplesWithProblems) {
        List<PeopleWithProblemsDto> peoplesWithProblemsDto = new ArrayList<>();
        for (PeopleWithProblems peopleWithProblems : peoplesWithProblems) {
            PeopleWithProblemsDto peopleWithProblemsDto =
                new PeopleWithProblemsDto(peopleWithProblems);
            peoplesWithProblemsDto.add(peopleWithProblemsDto);
        }
        
        return peoplesWithProblemsDto;
    }
    
    @Override
    public PeopleWithProblemsDto createDto(PeopleWithProblems peopleWithProblems) {
        return new PeopleWithProblemsDto(peopleWithProblems);
    }
}
