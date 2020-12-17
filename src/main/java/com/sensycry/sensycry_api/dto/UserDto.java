package com.sensycry.sensycry_api.dto;

import com.sensycry.sensycry_api.controller.implementations.PasswordController;
import com.sensycry.sensycry_api.controller.implementations.UserController;
import com.sensycry.sensycry_api.domain.User;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class UserDto extends ResourceSupport {
    private final User user;
    
    public UserDto(User user) {
        this.user = user;
        
        add(linkTo(methodOn(UserController.class).getUser(user.getId()))
            .withSelfRel());
        
        add(linkTo(
            methodOn(PasswordController.class).getPassword(user.getPasswordByPasswordId().getId()))
            .withRel("password"));
        
    }
    
    public Integer getUserId() {
        return user.getId();
    }
    
    public String getUsername() {
        return user.getUsername();
    }
    
    public String getEmail() {
        return user.getEmail();
    }
    
}
