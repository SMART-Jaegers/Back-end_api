package com.sensycry.sensycry_api.service.implementation;

import com.sensycry.sensycry_api.domain.PeopleWithProblems;
import com.sensycry.sensycry_api.exeption.NoSuchPeopleWithProblemsException;
import com.sensycry.sensycry_api.repository.PeopleWithProblemsRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PeopleWithProblemsService
    extends GeneralServiceImplementation<PeopleWithProblems, Integer> {
    
    private final PeopleWithProblemsRepository peopleWithProblemsRepository;
    
    public PeopleWithProblemsService(PeopleWithProblemsRepository peopleWithProblemsRepository) {
        this.peopleWithProblemsRepository = peopleWithProblemsRepository;
    }
    
    @Override
    protected JpaRepository<PeopleWithProblems, Integer> getRepository() {
        return peopleWithProblemsRepository;
    }
    
    @Override
    protected void throwException() {
        throw new NoSuchPeopleWithProblemsException();
        
    }
    
    @Override
    protected PeopleWithProblems mergeEntities(PeopleWithProblems newEntity,
                                               PeopleWithProblems entity) {
        
        newEntity.setConviction(entity.getConviction() != null ? entity.getConviction() :
            newEntity.getConviction());
        newEntity.setCourtDate(
            entity.getCourtDate() != null ? entity.getCourtDate() : newEntity.getCourtDate());
        
        return newEntity;
    }
}
