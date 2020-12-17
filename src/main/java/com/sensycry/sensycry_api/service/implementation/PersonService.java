package com.sensycry.sensycry_api.service.implementation;

import com.sensycry.sensycry_api.domain.Apartment;
import com.sensycry.sensycry_api.domain.Person;
import com.sensycry.sensycry_api.exeption.NoSuchApartmentException;
import com.sensycry.sensycry_api.exeption.NoSuchPersonException;
import com.sensycry.sensycry_api.repository.ApartmentRepository;
import com.sensycry.sensycry_api.repository.PersonRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Set;

@Service
public class PersonService extends GeneralServiceImplementation<Person, Integer> {
    
    private final PersonRepository personRepository;
    private final ApartmentRepository apartmentRepository;
    
    public PersonService(PersonRepository personRepository,
                         ApartmentRepository apartmentRepository) {
        this.personRepository = personRepository;
        this.apartmentRepository = apartmentRepository;
    }
    
    @Override
    protected JpaRepository<Person, Integer> getRepository() {
        return personRepository;
    }
    
    @Override
    protected void throwException() {
        throw new NoSuchPersonException();
    }
    
    @Override
    protected Person mergeEntities(Person newEntity, Person entity) {
        
        newEntity.setFirstName(
            entity.getFirstName() != null ? entity.getFirstName() : newEntity.getFirstName());
        newEntity
            .setSurname(entity.getSurname() != null ? entity.getSurname() : newEntity.getSurname());
        newEntity.setLastName(
            entity.getLastName() != null ? entity.getLastName() : newEntity.getLastName());
        newEntity.setPhoneNumber(
            entity.getPhoneNumber() != null ? entity.getPhoneNumber() : newEntity.getPhoneNumber());
        newEntity.setApartmentByFamilyId(
            entity.getApartmentByFamilyId() != null ? entity.getApartmentByFamilyId() :
                newEntity.getApartmentByFamilyId());
        
        return newEntity;
    }
    
    @Transactional
    public Set<Person> getPersonByApartment(Integer apartmentId) {
        if (apartmentRepository.existsById(apartmentId)) {
            Apartment apartment = apartmentRepository.findById(apartmentId).get();
            return apartment.getPeople();
        }
        throw new NoSuchApartmentException();
    }
}
