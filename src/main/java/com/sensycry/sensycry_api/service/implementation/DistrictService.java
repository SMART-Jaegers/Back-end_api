package com.sensycry.sensycry_api.service.implementation;

import com.sensycry.sensycry_api.domain.District;
import com.sensycry.sensycry_api.exeption.NoSuchDistrictException;
import com.sensycry.sensycry_api.repository.DistrictRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DistrictService extends GeneralServiceImplementation<District, Integer> {
    
    private final DistrictRepository districtRepository;
    
    public DistrictService(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }
    
    
    @Override
    protected JpaRepository<District, Integer> getRepository() {
        return districtRepository;
    }
    
    @Override
    protected void throwException() {
        throw new NoSuchDistrictException();
        
    }
    
    @Override
    protected District mergeEntities(District newEntity, District entity) {
        
        newEntity.setState(entity.getState() != null ? entity.getState() : newEntity.getState());
        newEntity.setCity(entity.getCity() != null ? entity.getCity() : newEntity.getCity());
        newEntity.setDistrict(
            entity.getDistrict() != null ? entity.getDistrict() : newEntity.getDistrict());
        newEntity
            .setCountry(entity.getCountry() != null ? entity.getCountry() : newEntity.getCountry());
        
        return newEntity;
    }
}
