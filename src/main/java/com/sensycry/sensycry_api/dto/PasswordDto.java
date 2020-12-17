package com.sensycry.sensycry_api.dto;

import com.sensycry.sensycry_api.controller.implementations.PasswordController;
import com.sensycry.sensycry_api.domain.Password;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class PasswordDto extends ResourceSupport {
    private final Password password;
    
    public PasswordDto(Password password) {
        this.password = password;
        
        add(linkTo(methodOn(PasswordController.class).getPassword(password.getId()))
            .withSelfRel());
        
    }
    
    public Integer getFamilyId() {
        return password.getId();
    }
    
    public String getPassword() {
        return password.getPassword();
    }
    
}
