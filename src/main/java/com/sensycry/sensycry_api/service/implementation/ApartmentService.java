package com.sensycry.sensycry_api.service.implementation;

import com.sensycry.sensycry_api.domain.Apartment;
import com.sensycry.sensycry_api.domain.District;
import com.sensycry.sensycry_api.exeption.NoSuchApartmentException;
import com.sensycry.sensycry_api.exeption.NoSuchDistrictException;
import com.sensycry.sensycry_api.repository.ApartmentRepository;
import com.sensycry.sensycry_api.repository.DistrictRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ApartmentService extends GeneralServiceImplementation<Apartment, Integer> {

  private final ApartmentRepository apartmentRepository;
  private final DistrictRepository districtRepository;

  public ApartmentService(
      ApartmentRepository apartmentRepository, DistrictRepository districtRepository) {
    this.apartmentRepository = apartmentRepository;
    this.districtRepository = districtRepository;
  }

  @Override
  protected JpaRepository<Apartment, Integer> getRepository() {
    return apartmentRepository;
  }

  @Override
  protected void throwException() {
    throw new NoSuchApartmentException();
  }

  @Override
  protected Apartment mergeEntities(Apartment newEntity, Apartment entity) {
    newEntity.setAddress(
        entity.getAddress() != null ? entity.getAddress() : newEntity.getAddress());
    newEntity.setDevices(
        entity.getDevices() != null ? entity.getDevices() : newEntity.getDevices());
    newEntity.setDistrict(
        entity.getDistrict() != null ? entity.getDistrict() : newEntity.getDistrict());
    newEntity.setIncedents(
        entity.getIncedents() != null ? entity.getIncedents() : newEntity.getIncedents());
    newEntity.setPeople(entity.getPeople() != null ? entity.getPeople() : newEntity.getPeople());

    return newEntity;
  }

  @Transactional
  public Set<Apartment> getApartmentsByDistrict(Integer districtId) {
    if (districtRepository.existsById(districtId)) {
      District district = districtRepository.findById(districtId).get();
      return district.getApartmentsById();
    }
    throw new NoSuchDistrictException();
  }

  @Transactional
  public List<Apartment> getApartmentsByFamilyId(String familyId) {
    return apartmentRepository.findAll().stream()
        .filter(apartment -> apartment.getFamilyId().toString().contains(familyId))
        .collect(Collectors.toList());
  }
}
