package com.sensycry.sensycry_api.controller.implementations;

import com.sensycry.sensycry_api.controller.ControllerWithDto;
import com.sensycry.sensycry_api.domain.Apartment;
import com.sensycry.sensycry_api.dto.ApartmentDto;
import com.sensycry.sensycry_api.service.implementation.ApartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin
@RestController
public class ApartmentController implements ControllerWithDto<ApartmentDto, Apartment> {

  private final ApartmentService apartmentService;

  public ApartmentController(ApartmentService apartmentService) {
    this.apartmentService = apartmentService;
  }

  @GetMapping(value = "/sensycry/apartment")
  public ResponseEntity<List<ApartmentDto>> getApartments() {
    List<Apartment> apartments = apartmentService.getEntities();
    List<ApartmentDto> apartmentsDto = createDtos(apartments);
    return new ResponseEntity<>(apartmentsDto, HttpStatus.OK);
  }

  @GetMapping(value = "/sensycry/apartment/input/{familyId}")
  public ResponseEntity<List<ApartmentDto>> getApartmentsByFirstNumberOf(
      @PathVariable String familyId) {
    List<Apartment> apartments = apartmentService.getApartmentsByFamilyId(familyId);
    List<ApartmentDto> apartmentsDto = createDtos(apartments);
    return new ResponseEntity<>(apartmentsDto, HttpStatus.OK);
  }

  @GetMapping(value = "/sensycry/apartment/{id}")
  public ResponseEntity<ApartmentDto> getApartment(@PathVariable Integer id) {
    Apartment apartment = apartmentService.getEntity(id);
    ApartmentDto apartmentDto = createDto(apartment);
    return new ResponseEntity<>(apartmentDto, HttpStatus.OK);
  }

  @PostMapping(value = "/sensycry/apartment")
  public ResponseEntity<ApartmentDto> setApartment(@RequestBody Apartment apartment) {
    Apartment newApartment = apartmentService.createEntity(apartment);
    ApartmentDto apartmentDto = createDto(newApartment);
    return new ResponseEntity<>(apartmentDto, HttpStatus.OK);
  }

  @PutMapping(value = "/sensycry/apartment/{id}")
  public ResponseEntity<ApartmentDto> updateApartment(
      @RequestBody Apartment apartment, @PathVariable Integer id) {
    Apartment newApartment = apartmentService.updateEntity(apartment, id);
    ApartmentDto apartmentDto = createDto(newApartment);
    return new ResponseEntity<>(apartmentDto, HttpStatus.OK);
  }

  @DeleteMapping(value = "/sensycry/apartment/{id}")
  public ResponseEntity<ApartmentDto> deleteApartment(@PathVariable Integer id) {
    Apartment oldApartment = apartmentService.deleteEntity(id);
    ApartmentDto apartmentDto = createDto(oldApartment);
    return new ResponseEntity<>(apartmentDto, HttpStatus.OK);
  }

  @GetMapping(value = "/sensycry/apartment/district/{id}")
  public ResponseEntity<List<ApartmentDto>> getApartmentsByDistrict(@PathVariable Integer id) {
    Set<Apartment> apartments = apartmentService.getApartmentsByDistrict(id);
    List<ApartmentDto> apartmentsDto = createDtos(apartments);
    return new ResponseEntity<>(apartmentsDto, HttpStatus.OK);
  }

  @Override
  public List<ApartmentDto> createDtos(Iterable<Apartment> apartments) {
    List<ApartmentDto> apartmentsDto = new ArrayList<>();
    for (Apartment apartment : apartments) {
      ApartmentDto apartmentDto = new ApartmentDto(apartment);
      apartmentsDto.add(apartmentDto);
    }
    return apartmentsDto;
  }

  @Override
  public ApartmentDto createDto(Apartment apartment) {
    return new ApartmentDto(apartment);
  }
}
