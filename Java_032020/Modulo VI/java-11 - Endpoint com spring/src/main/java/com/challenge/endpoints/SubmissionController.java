package com.challenge.endpoints;

import com.challenge.dto.SubmissionDTO;
import com.challenge.mappers.SubmissionMapper;
import com.challenge.service.impl.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubmissionController {

    @Autowired
    SubmissionService submissionService;

    @Autowired
    SubmissionMapper submissionMapper;

    @GetMapping("/submission")
    public ResponseEntity<SubmissionDTO> findSubmission (@RequestParam("challengeId") Long challengeId ,
                                                         @RequestParam("accelerationId") Long accelerationId) {

        return new ResponseEntity(
                  submissionMapper.map(submissionService.findByChallengeIdAndAccelerationId(challengeId,accelerationId))
                , HttpStatus.OK
        );

    }




}
