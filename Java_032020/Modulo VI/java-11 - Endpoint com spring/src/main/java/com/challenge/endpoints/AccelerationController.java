package com.challenge.endpoints;

import com.challenge.dto.AccelerationDTO;
import com.challenge.endpoints.adivice.ResourceNotFoundException;
import com.challenge.service.impl.AccelerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AccelerationController {

    @Autowired
    AccelerationService accelerationService;

    @GetMapping("/acceleration/{id}")
    public ResponseEntity<AccelerationDTO> findAccelerations(@PathVariable("id") Long id){

        return new ResponseEntity(
                new AccelerationDTO(
                        accelerationService
                        .findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Acceleration"))
                ) ,
                HttpStatus.OK
        );
    }

    @GetMapping("/acceleration")
    public ResponseEntity<List<AccelerationDTO>> findAllAccelerations (@RequestParam("companyId") Long companyId){

        return new ResponseEntity(
                        accelerationService.findByCompanyId(companyId).stream().map(AccelerationDTO::new).collect(Collectors.toList()) ,
                        HttpStatus.OK
        );
    }







}
