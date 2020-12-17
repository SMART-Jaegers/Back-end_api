package com.sensycry.sensycry_api.dto;

import com.sensycry.sensycry_api.controller.implementations.ApartmentController;
import com.sensycry.sensycry_api.controller.implementations.DistrictController;
import com.sensycry.sensycry_api.domain.District;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class DistrictDto extends ResourceSupport {
    private final District district;
    
    public DistrictDto(District district) {
        this.district = district;
        
        add(linkTo(methodOn(DistrictController.class).getDistrict(district.getId()))
            .withSelfRel());
        
        add(linkTo(methodOn(ApartmentController.class).getApartmentsByDistrict(district.getId()))
            .withRel("apartaments"));
    }
    
    public Integer getDistrictId() {
        return district.getId();
    }
    
    public String getState() {
        return district.getState();
    }
    
    public String getCity() {
        return district.getCity();
    }
    
    public String getDistrict() {
        return district.getDistrict();
    }
    
    public String getCountry() {
        return district.getCountry();
    }
    
}
