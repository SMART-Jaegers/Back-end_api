package com.sensycry.sensycry_api.controller;

import com.sensycry.sensycry_api.dto.MessageDto;
import com.sensycry.sensycry_api.exeption.NoSuchApartmentException;
import com.sensycry.sensycry_api.exeption.NoSuchDeviceException;
import com.sensycry.sensycry_api.exeption.NoSuchDistrictException;
import com.sensycry.sensycry_api.exeption.NoSuchIncedentException;
import com.sensycry.sensycry_api.exeption.NoSuchPasswordException;
import com.sensycry.sensycry_api.exeption.NoSuchPeopleWithProblemsException;
import com.sensycry.sensycry_api.exeption.NoSuchPersonException;
import com.sensycry.sensycry_api.exeption.NoSuchUserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NoSuchApartmentException.class)
    ResponseEntity<MessageDto> handleNoSuchApartmentException() {
        return new ResponseEntity<>(
            new MessageDto("Such Apartment is not present in database"), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(NoSuchDeviceException.class)
    ResponseEntity<MessageDto> handleNoSuchDeviceException() {
        return new ResponseEntity<>(
            new MessageDto("Such Device is not present in database"), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(NoSuchDistrictException.class)
    ResponseEntity<MessageDto> handleNoSuchDistrictException() {
        return new ResponseEntity<>(
            new MessageDto("Such District is not present in database"), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(NoSuchIncedentException.class)
    ResponseEntity<MessageDto> handleNoSuchIncedentException() {
        return new ResponseEntity<>(
            new MessageDto("Such Incident is not present in database"), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(NoSuchPasswordException.class)
    ResponseEntity<MessageDto> handleNoSuchPasswordException() {
        return new ResponseEntity<>(
            new MessageDto("Such Password is not present in database"), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(NoSuchPeopleWithProblemsException.class)
    ResponseEntity<MessageDto> handleNoSuchPeopleWithProblemsException() {
        return new ResponseEntity<>(
            new MessageDto("Such People with problems is not present in database"),
            HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(NoSuchPersonException.class)
    ResponseEntity<MessageDto> handleNoSuchPersonException() {
        return new ResponseEntity<>(
            new MessageDto("Such Person is not present in database"), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(NoSuchUserException.class)
    ResponseEntity<MessageDto> handleNoSuchUserException() {
        return new ResponseEntity<>(
            new MessageDto("Such User is not present in database"), HttpStatus.NOT_FOUND);
    }
    
    
}
