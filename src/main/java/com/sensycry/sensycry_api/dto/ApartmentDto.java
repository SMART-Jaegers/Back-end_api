package com.sensycry.sensycry_api.dto;

import com.sensycry.sensycry_api.controller.implementations.ApartmentController;
import com.sensycry.sensycry_api.controller.implementations.DeviceController;
import com.sensycry.sensycry_api.controller.implementations.DistrictController;
import com.sensycry.sensycry_api.controller.implementations.IncedentController;
import com.sensycry.sensycry_api.controller.implementations.PersonController;
import com.sensycry.sensycry_api.domain.Apartment;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class ApartmentDto extends ResourceSupport {

  private final Apartment apartment;

  public ApartmentDto(Apartment apartment) {
    this.apartment = apartment;

    add(
        linkTo(methodOn(ApartmentController.class).getApartment(apartment.getFamilyId()))
            .withSelfRel());

    add(
        linkTo(methodOn(DeviceController.class).getDevicesByApartment(apartment.getFamilyId()))
            .withRel("device"));

    add(
        linkTo(methodOn(PersonController.class).getPersonsByApartment(apartment.getFamilyId()))
            .withRel("persons"));

    add(
        linkTo(methodOn(IncedentController.class).getIncedentsByApartment(apartment.getFamilyId()))
            .withRel("incidents"));

    add(
        linkTo(methodOn(DistrictController.class).getDistrict(apartment.getDistrict().getId()))
            .withRel("district"));
  }

  public Integer getFamilyId() {
    return apartment.getFamilyId();
  }

  public String getAddress() {
    return apartment.getAddress();
  }
}
