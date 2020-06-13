package com.challenge.endpoints;

import com.challenge.dto.UserResponseDTO;
import com.challenge.endpoints.adivice.ResourceNotFoundException;
import com.challenge.service.impl.UserService;
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
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/user/{id}")
    public ResponseEntity<UserResponseDTO> findUserById(@PathVariable("id") Long id) {

        return new ResponseEntity(
                                    new UserResponseDTO(
                                            userService.findById(id).orElseThrow(() -> new ResourceNotFoundException("User"))
                                    ) , HttpStatus.OK
        );
    }


    @GetMapping("user")
    public ResponseEntity<List<UserResponseDTO>> findUsers(
                                @RequestParam(value = "accelerationName" , required = false) Optional<String> accelerationName ,
                                @RequestParam(value = "companyId"        , required = false) Optional<Long>   companyId ) {

        return new ResponseEntity(   accelerationName.map(userService::findByAccelerationName)
                                            .orElseGet( () -> companyId.map(userService::findByCompanyId).orElse(new ArrayList<>()))
                                            , HttpStatus.OK
        );
    }

}
