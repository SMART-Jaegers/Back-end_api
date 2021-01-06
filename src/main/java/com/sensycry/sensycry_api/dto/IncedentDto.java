package com.sensycry.sensycry_api.dto;

import com.sensycry.sensycry_api.controller.implementations.ApartmentController;
import com.sensycry.sensycry_api.controller.implementations.IncedentController;
import com.sensycry.sensycry_api.domain.Incedent;
import org.springframework.hateoas.ResourceSupport;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class IncedentDto extends ResourceSupport {
  private final Incedent incedent;

  public IncedentDto(Incedent incedent) {
    this.incedent = incedent;

    add(linkTo(methodOn(IncedentController.class).getIncedent(incedent.getId())).withSelfRel());

    add(
        linkTo(
                methodOn(ApartmentController.class)
                    .getApartment(incedent.getApartmentByFamilyId().getFamilyId()))
            .withRel("apartament"));
  }

  public Integer getIncidentId() {
    return incedent.getId();
  }

  public Timestamp getDate() {
    return incedent.getDate();
  }

  public Time getDuringTime() {
    return incedent.getDuringTime();
  }

  public Byte getAggressionHappened() {
    return incedent.getAggresionHappend();
  }

  public BigDecimal getAccuracy() {
    return incedent.getAccuracy();
  }

  public String getNameRecord() {
    return incedent.getNameRecord();
  }

  public String getPathRecord() {
    return incedent.getPathRecord();
  }

  public String getSize() {
    return incedent.getSize();
  }
}
