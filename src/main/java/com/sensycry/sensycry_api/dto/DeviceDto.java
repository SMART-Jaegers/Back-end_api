package com.sensycry.sensycry_api.dto;

import com.sensycry.sensycry_api.controller.implementations.ApartmentController;
import com.sensycry.sensycry_api.controller.implementations.DeviceController;
import com.sensycry.sensycry_api.domain.Device;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class DeviceDto extends ResourceSupport {
  private final Device device;

  public DeviceDto(Device device) {
    this.device = device;

    add(
        linkTo(
                methodOn(ApartmentController.class)
                    .getApartment(device.getApartment().getFamilyId()))
            .withRel("apartament"));

    add(linkTo(methodOn(DeviceController.class).getDevice(device.getId())).withSelfRel());
  }

  public Integer getDeviceId() {
    return device.getId();
  }

  public String getName() {
    return device.getName();
  }
}
