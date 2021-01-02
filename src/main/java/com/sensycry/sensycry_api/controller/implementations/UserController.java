package com.sensycry.sensycry_api.controller.implementations;

import com.sensycry.sensycry_api.controller.ControllerWithDto;
import com.sensycry.sensycry_api.domain.User;
import com.sensycry.sensycry_api.dto.UserDto;
import com.sensycry.sensycry_api.service.implementation.UserService;
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

@CrossOrigin
@RestController
public class UserController implements ControllerWithDto<UserDto, User> {
    
    private final UserService userService;
    
    public UserController(
        UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping(value = "/sensycry/user")
    public ResponseEntity<List<UserDto>> getUsers() {
        List<User> users = userService.getEntities();
        List<UserDto> usersDto = createDtos(users);
        return new ResponseEntity<>(usersDto, HttpStatus.OK);
    }
    
    @GetMapping(value = "/sensycry/user/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Integer id) {
        User user = userService.getEntity(id);
        UserDto userDto = createDto(user);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
    
    @PostMapping(value = "/sensycry/user")
    public ResponseEntity<UserDto> setUser(@RequestBody User user) {
        User newUser = userService.createEntity(user);
        UserDto userDto = createDto(newUser);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
    
    @PutMapping(value = "/sensycry/user/{id}")
    public ResponseEntity<UserDto> updateUser(
        @RequestBody User user, @PathVariable Integer id) {
        User newUser = userService.updateEntity(user, id);
        UserDto userDto = createDto(newUser);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/sensycry/user/{id}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable Integer id) {
        User oldUser = userService.deleteEntity(id);
        UserDto userDto = createDto(oldUser);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
    
    @Override
    public List<UserDto> createDtos(Iterable<User> users) {
        List<UserDto> usersDto = new ArrayList<>();
        for (User user : users) {
            UserDto userDto = new UserDto(user);
            usersDto.add(userDto);
        }
        return usersDto;
    }
    
    @Override
    public UserDto createDto(User user) {
        return new UserDto(user);
    }
}
