package com.challenge.endpoints;

import com.challenge.dto.CompanyDTO;
import com.challenge.endpoints.adivice.ResourceNotFoundException;
import com.challenge.service.impl.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping("/company/{id}")
    public ResponseEntity<CompanyDTO> findCompanyById(@PathVariable("id") Long id) {

        return new ResponseEntity(
                new CompanyDTO(
                        companyService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Company"))
                ) , HttpStatus.OK
        );
    }


    @GetMapping("/company")
    public ResponseEntity<List<CompanyDTO>> findCompany(
            @RequestParam(value = "accelerationId" , required = false) Optional<Long> accelerationId ,
            @RequestParam(value = "userId"         , required = false) Optional<Long> userId ) {

        return new ResponseEntity(
                accelerationId.map(companyService::findByAccelerationId)
                .orElseGet( () -> userId.map(companyService::findByUserId).orElse(new ArrayList<>()))
                , HttpStatus.OK
        );
    }


}
