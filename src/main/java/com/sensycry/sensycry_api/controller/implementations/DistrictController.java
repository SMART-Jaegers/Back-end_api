package com.sensycry.sensycry_api.controller.implementations;

import com.sensycry.sensycry_api.controller.ControllerWithDto;
import com.sensycry.sensycry_api.domain.District;
import com.sensycry.sensycry_api.dto.DistrictDto;
import com.sensycry.sensycry_api.service.implementation.DistrictService;
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
public class DistrictController implements ControllerWithDto<DistrictDto, District> {
    
    private final DistrictService districtService;
    
    public DistrictController(
        DistrictService districtService) {
        this.districtService = districtService;
    }
    
    @GetMapping(value = "/sensycry/district")
    public ResponseEntity<List<DistrictDto>> getDistricts() {
        List<District> districts = districtService.getEntities();
        List<DistrictDto> districtsDto = createDtos(districts);
        return new ResponseEntity<>(districtsDto, HttpStatus.OK);
    }
    
    @GetMapping(value = "/sensycry/district/{id}")
    public ResponseEntity<DistrictDto> getDistrict(@PathVariable Integer id) {
        District district = districtService.getEntity(id);
        DistrictDto districtDto = createDto(district);
        return new ResponseEntity<>(districtDto, HttpStatus.OK);
    }
    
    @PostMapping(value = "/sensycry/district")
    public ResponseEntity<DistrictDto> setDistrict(@RequestBody District district) {
        District newDistrict = districtService.createEntity(district);
        DistrictDto districtDto = createDto(newDistrict);
        return new ResponseEntity<>(districtDto, HttpStatus.OK);
    }
    
    @PutMapping(value = "/sensycry/district/{id}")
    public ResponseEntity<DistrictDto> updateDistrict(
        @RequestBody District district, @PathVariable Integer id) {
        District newDistrict = districtService.updateEntity(district, id);
        DistrictDto districtDto = createDto(newDistrict);
        return new ResponseEntity<>(districtDto, HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/sensycry/district/{id}")
    public ResponseEntity<DistrictDto> deleteDistrict(@PathVariable Integer id) {
        District oldDistrict = districtService.deleteEntity(id);
        DistrictDto districtDto = createDto(oldDistrict);
        return new ResponseEntity<>(districtDto, HttpStatus.OK);
    }
    
    @Override
    public List<DistrictDto> createDtos(Iterable<District> districts) {
        List<DistrictDto> districtsDto = new ArrayList<>();
        for (District district : districts) {
            DistrictDto districtDto = new DistrictDto(district);
            districtsDto.add(districtDto);
        }
        return districtsDto;
    }
    
    @Override
    public DistrictDto createDto(District district) {
        return new DistrictDto(district);
    }
}
