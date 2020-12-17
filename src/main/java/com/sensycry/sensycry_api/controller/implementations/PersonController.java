package com.sensycry.sensycry_api.controller.implementations;

import com.sensycry.sensycry_api.controller.ControllerWithDto;
import com.sensycry.sensycry_api.domain.Person;
import com.sensycry.sensycry_api.dto.PersonDto;
import com.sensycry.sensycry_api.service.implementation.PersonService;
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
import java.util.Set;

@RestController
public class PersonController implements ControllerWithDto<PersonDto, Person> {
    private final PersonService personService;
    
    public PersonController(
        PersonService personService) {
        this.personService = personService;
    }
    
    @GetMapping(value = "/sensycry/person")
    public ResponseEntity<List<PersonDto>> getPeople() {
        List<Person> people = personService.getEntities();
        List<PersonDto> peopleDto = createDtos(people);
        return new ResponseEntity<>(peopleDto, HttpStatus.OK);
    }
    
    @GetMapping(value = "/sensycry/person/{id}")
    public ResponseEntity<PersonDto> getPerson(@PathVariable Integer id) {
        Person person = personService.getEntity(id);
        PersonDto personDto = createDto(person);
        return new ResponseEntity<>(personDto, HttpStatus.OK);
    }
    
    @PostMapping(value = "/sensycry/person")
    public ResponseEntity<PersonDto> setPerson(@RequestBody Person person) {
        Person newPerson = personService.createEntity(person);
        PersonDto personDto = createDto(newPerson);
        return new ResponseEntity<>(personDto, HttpStatus.OK);
    }
    
    @PutMapping(value = "/sensycry/person/{id}")
    public ResponseEntity<PersonDto> updatePerson(
        @RequestBody Person person, @PathVariable Integer id) {
        Person newPerson = personService.updateEntity(person, id);
        PersonDto personDto = createDto(newPerson);
        return new ResponseEntity<>(personDto, HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/sensycry/person/{id}")
    public ResponseEntity<PersonDto> deletePerson(@PathVariable Integer id) {
        Person oldPerson = personService.deleteEntity(id);
        PersonDto personDto = createDto(oldPerson);
        return new ResponseEntity<>(personDto, HttpStatus.OK);
    }
    
    @GetMapping(value = "/sensycry/person/apartment/{id}")
    public ResponseEntity<List<PersonDto>> getPersonsByApartment(@PathVariable Integer id) {
        Set<Person> people = personService.getPersonByApartment(id);
        List<PersonDto> peopleDto = createDtos(people);
        return new ResponseEntity<>(peopleDto, HttpStatus.OK);
    }
    
    @Override
    public List<PersonDto> createDtos(Iterable<Person> people) {
        List<PersonDto> peopleDto = new ArrayList<>();
        for (Person person : people) {
            PersonDto personDto = new PersonDto(person);
            peopleDto.add(personDto);
        }
        return peopleDto;
    }
    
    @Override
    public PersonDto createDto(Person person) {
        return new PersonDto(person);
    }
}
