package com.challenge.endpoints;

import com.challenge.dto.ChallengeDTO;
import com.challenge.service.impl.ChallengeService;
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
public class ChallengeController {

    @Autowired
    ChallengeService challengeService;

    @GetMapping("/challenge")
    public ResponseEntity<List<ChallengeDTO>> findAll(@RequestParam("accelerationId") Long accellerationId,
                                                      @RequestParam("userId")         Long userId) {
        return new ResponseEntity(
                challengeService.findByAccelerationIdAndUserId(accellerationId,userId).stream().map(ChallengeDTO::new).collect(Collectors.toList())
                , HttpStatus.OK
        );
    }
}
