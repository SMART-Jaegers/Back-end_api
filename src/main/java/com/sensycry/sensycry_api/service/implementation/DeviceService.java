package com.sensycry.sensycry_api.service.implementation;

import com.sensycry.sensycry_api.domain.Apartment;
import com.sensycry.sensycry_api.domain.Device;
import com.sensycry.sensycry_api.exeption.NoSuchApartmentException;
import com.sensycry.sensycry_api.exeption.NoSuchDeviceException;
import com.sensycry.sensycry_api.repository.ApartmentRepository;
import com.sensycry.sensycry_api.repository.DeviceRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Set;

@Service
public class DeviceService extends GeneralServiceImplementation<Device, Integer> {
    
    private final DeviceRepository deviceRepository;
    private final ApartmentRepository apartmentRepository;
    
    public DeviceService(DeviceRepository deviceRepository,
                         ApartmentRepository apartmentRepository) {
        this.deviceRepository = deviceRepository;
        this.apartmentRepository = apartmentRepository;
    }
    
    @Override
    protected JpaRepository<Device, Integer> getRepository() {
        return deviceRepository;
    }
    
    @Override
    protected void throwException() {
        throw new NoSuchDeviceException();
    }
    
    @Override
    protected Device mergeEntities(Device newEntity, Device entity) {
        newEntity.setName(entity.getName() != null ? entity.getName() : newEntity.getName());
        newEntity.setApartment(
            entity.getApartment() != null ? entity.getApartment() : newEntity.getApartment());
        return newEntity;
    }
    
    @Transactional
    public Set<Device> getDevicesByApartment(Integer apartment_id) {
        if (apartmentRepository.existsById(apartment_id)) {
            Apartment apartment = apartmentRepository.findById(apartment_id).get();
            return apartment.getDevices();
            
        }
        throw new NoSuchApartmentException();
    }
}
