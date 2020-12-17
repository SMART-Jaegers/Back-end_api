package com.sensycry.sensycry_api.dto;

import com.sensycry.sensycry_api.controller.implementations.PeopleWithProblemsController;
import com.sensycry.sensycry_api.controller.implementations.PersonController;
import com.sensycry.sensycry_api.domain.PeopleWithProblems;
import org.springframework.hateoas.ResourceSupport;

import java.sql.Date;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class PeopleWithProblemsDto extends ResourceSupport {
    
    private final PeopleWithProblems peopleWithProblems;
    
    public PeopleWithProblemsDto(PeopleWithProblems peopleWithProblems) {
        this.peopleWithProblems = peopleWithProblems;
        
        add(linkTo(methodOn(PeopleWithProblemsController.class)
            .getPeopleWithProblems(peopleWithProblems.getPersonId()))
            .withSelfRel());
        
        add(linkTo(methodOn(PersonController.class)
            .getPerson(peopleWithProblems.getPersonByPersonId().getId()))
            .withRel("person"));
        
        
    }
    
    public Integer getPeopleWithProblemsId() {
        return peopleWithProblems.getPersonId();
    }
    
    public String getConviction() {
        return peopleWithProblems.getConviction();
    }
    
    public Date getCourtDate() {
        return peopleWithProblems.getCourtDate();
    }
    
}
