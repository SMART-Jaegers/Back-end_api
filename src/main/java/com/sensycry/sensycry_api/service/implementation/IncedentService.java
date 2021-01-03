package com.sensycry.sensycry_api.service.implementation;

import com.sensycry.sensycry_api.domain.Apartment;
import com.sensycry.sensycry_api.domain.Incedent;
import com.sensycry.sensycry_api.exeption.NoSuchApartmentException;
import com.sensycry.sensycry_api.exeption.NoSuchIncedentException;
import com.sensycry.sensycry_api.repository.ApartmentRepository;
import com.sensycry.sensycry_api.repository.IncedentRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class IncedentService extends GeneralServiceImplementation<Incedent, Integer> {
    
    private final IncedentRepository incedentRepository;
    private final ApartmentRepository apartmentRepository;
    
    public IncedentService(IncedentRepository incedentRepository,
                           ApartmentRepository apartmentRepository) {
        this.incedentRepository = incedentRepository;
        this.apartmentRepository = apartmentRepository;
    }
    
    @Override
    protected JpaRepository<Incedent, Integer> getRepository() {
        return incedentRepository;
    }
    
    @Override
    protected void throwException() {
        throw new NoSuchIncedentException();
    }
    
    @Override
    protected Incedent mergeEntities(Incedent newEntity, Incedent entity) {
        newEntity.setDate(entity.getDate() != null ? entity.getDate() : newEntity.getDate());
        newEntity.setDuringTime(
            entity.getDuringTime() != null ? entity.getDuringTime() : newEntity.getDuringTime());
        newEntity.setAggresionHappend(
            entity.getAggresionHappend() != null ? entity.getAggresionHappend() :
                newEntity.getAggresionHappend());
        newEntity.setAccuracy(
            entity.getAccuracy() != null ? entity.getAccuracy() : newEntity.getAccuracy());
        newEntity.setNameRecord(
            entity.getNameRecord() != null ? entity.getNameRecord() : newEntity.getNameRecord());
        newEntity.setPathRecord(
            entity.getPathRecord() != null ? entity.getPathRecord() : newEntity.getPathRecord());
        newEntity.setSize(entity.getSize() != null ? entity.getSize() : newEntity.getSize());
        newEntity.setApartmentByFamilyId(
            entity.getApartmentByFamilyId() != null ? entity.getApartmentByFamilyId() :
                newEntity.getApartmentByFamilyId());
        
        return newEntity;
    }
    
    @Transactional
    public Set<Incedent> getIncedentByApartment(Integer apartamentId) {
        if (apartmentRepository.existsById(apartamentId)) {
            Apartment apartment = apartmentRepository.findById(apartamentId).get();
            return apartment.getIncedents();
        }
        throw new NoSuchApartmentException();
        
    }
    
    @Transactional
    public List<Incedent> getIncedentWithLimit(Integer count) {
        return incedentRepository.findAll().stream()
            .sorted(Comparator.comparing(Incedent::getDate).reversed())
            .limit(count).collect(Collectors.toList());
    }
}
