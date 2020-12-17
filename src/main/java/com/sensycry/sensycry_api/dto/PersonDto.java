package com.sensycry.sensycry_api.dto;

import com.sensycry.sensycry_api.controller.implementations.ApartmentController;
import com.sensycry.sensycry_api.controller.implementations.PersonController;
import com.sensycry.sensycry_api.domain.Person;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class PersonDto extends ResourceSupport {
    private final Person person;
    
    public PersonDto(Person person) {
        this.person = person;
        
        add(linkTo(methodOn(PersonController.class).getPerson(person.getId()))
            .withSelfRel());
        
        add(linkTo(methodOn(ApartmentController.class)
            .getApartment(person.getApartmentByFamilyId().getFamilyId()))
            .withRel("device"));
    }
    
    public Integer getPersonId() {
        return person.getId();
    }
    
    public String getFirstName() {
        return person.getFirstName();
    }
    
    public String getSurname() {
        return person.getSurname();
    }
    
    public String getLastName() {
        return person.getLastName();
    }
    
    public String getPhoneNumber() {
        return person.getPhoneNumber();
    }
    
}
