package com.sensycry.sensycry_api.controller.implementations;

import com.sensycry.sensycry_api.controller.ControllerWithDto;
import com.sensycry.sensycry_api.domain.Device;
import com.sensycry.sensycry_api.dto.DeviceDto;
import com.sensycry.sensycry_api.service.implementation.DeviceService;
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
import java.util.Set;

@RestController
public class DeviceController implements ControllerWithDto<DeviceDto, Device> {
    
    private final DeviceService deviceService;
    
    public DeviceController(
        DeviceService deviceService) {
        this.deviceService = deviceService;
    }
    
    @GetMapping(value = "/sensycry/device")
    public ResponseEntity<List<DeviceDto>> getDevices() {
        List<Device> devices = deviceService.getEntities();
        List<DeviceDto> devicesDto = createDtos(devices);
        return new ResponseEntity<>(devicesDto, HttpStatus.OK);
    }
    
    @GetMapping(value = "/sensycry/device/{id}")
    public ResponseEntity<DeviceDto> getDevice(@PathVariable Integer id) {
        Device device = deviceService.getEntity(id);
        DeviceDto deviceDto = createDto(device);
        return new ResponseEntity<>(deviceDto, HttpStatus.OK);
    }
    
    @PostMapping(value = "/sensycry/device")
    public ResponseEntity<DeviceDto> setDevice(@RequestBody Device device) {
        Device newDevice = deviceService.createEntity(device);
        DeviceDto deviceDto = createDto(newDevice);
        return new ResponseEntity<>(deviceDto, HttpStatus.OK);
    }
    
    @PutMapping(value = "/sensycry/device/{id}")
    public ResponseEntity<DeviceDto> updateDevice(
        @RequestBody Device device, @PathVariable Integer id) {
        Device newDevice = deviceService.updateEntity(device, id);
        DeviceDto deviceDto = createDto(newDevice);
        return new ResponseEntity<>(deviceDto, HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/sensycry/device/{id}")
    public ResponseEntity<DeviceDto> deleteDevice(@PathVariable Integer id) {
        Device oldDevice = deviceService.deleteEntity(id);
        DeviceDto deviceDto = createDto(oldDevice);
        return new ResponseEntity<>(deviceDto, HttpStatus.OK);
    }
    
    
    @GetMapping(value = "/sensycry/device/apartament/{id}")
    public ResponseEntity<List<DeviceDto>> getDevicesByApartment(@PathVariable Integer id) {
        Set<Device> devices = deviceService.getDevicesByApartment(id);
        List<DeviceDto> devicesDto = createDtos(devices);
        return new ResponseEntity<>(devicesDto, HttpStatus.OK);
    }
    
    @Override
    public List<DeviceDto> createDtos(Iterable<Device> devices) {
        List<DeviceDto> deviceDtos = new ArrayList<>();
        for (Device device : devices) {
            DeviceDto deviceDto = new DeviceDto(device);
            deviceDtos.add(deviceDto);
        }
        return deviceDtos;
    }
    
    @Override
    public DeviceDto createDto(Device device) {
        return new DeviceDto(device);
    }
}
