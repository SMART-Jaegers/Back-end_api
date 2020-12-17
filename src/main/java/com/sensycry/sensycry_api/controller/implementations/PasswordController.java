package com.sensycry.sensycry_api.controller.implementations;

import com.sensycry.sensycry_api.controller.ControllerWithDto;
import com.sensycry.sensycry_api.domain.Password;
import com.sensycry.sensycry_api.dto.PasswordDto;
import com.sensycry.sensycry_api.service.implementation.PasswordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PasswordController implements ControllerWithDto<PasswordDto, Password> {
    private final PasswordService passwordService;
    
    public PasswordController(
        PasswordService passwordService) {
        this.passwordService = passwordService;
    }
    
    @GetMapping(value = "/sensycry/password")
    public ResponseEntity<List<PasswordDto>> getPasswords() {
        List<Password> passwords = passwordService.getEntities();
        List<PasswordDto> passwordsDto = createDtos(passwords);
        return new ResponseEntity<>(passwordsDto, HttpStatus.OK);
    }
    
    @GetMapping(value = "/sensycry/password/{id}")
    public ResponseEntity<PasswordDto> getPassword(@PathVariable Integer id) {
        Password password = passwordService.getEntity(id);
        PasswordDto passwordDto = createDto(password);
        return new ResponseEntity<>(passwordDto, HttpStatus.OK);
    }
    
    @PostMapping(value = "/sensycry/password")
    public ResponseEntity<PasswordDto> setPassword(@RequestBody Password password) {
        Password newPassword = passwordService.createEntity(password);
        PasswordDto passwordDto = createDto(newPassword);
        return new ResponseEntity<>(passwordDto, HttpStatus.OK);
    }
    
    @PutMapping(value = "/sensycry/password/{id}")
    public ResponseEntity<PasswordDto> updatePassword(
        @RequestBody Password password, @PathVariable Integer id) {
        Password newPassword = passwordService.updateEntity(password, id);
        PasswordDto passwordDto = createDto(newPassword);
        return new ResponseEntity<>(passwordDto, HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/sensycry/password/{id}")
    public ResponseEntity<PasswordDto> deletePassword(@PathVariable Integer id) {
        Password oldPassword = passwordService.deleteEntity(id);
        PasswordDto passwordDto = createDto(oldPassword);
        return new ResponseEntity<>(passwordDto, HttpStatus.OK);
    }
    
    @Override
    public List<PasswordDto> createDtos(Iterable<Password> passwords) {
        List<PasswordDto> passwordsDto = new ArrayList<>();
        for (Password password : passwords) {
            PasswordDto passwordDto = new PasswordDto(password);
            passwordsDto.add(passwordDto);
        }
        return passwordsDto;
    }
    
    @Override
    public PasswordDto createDto(Password password) {
        return new PasswordDto(password);
    }
}
