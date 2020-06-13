package com.challenge.endpoints;

import com.challenge.dto.CandidateDTO;
import com.challenge.endpoints.adivice.ResourceNotFoundException;
import com.challenge.entity.Candidate;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.impl.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CadidateController {

    @Autowired
    CandidateService candidateService;

    @Autowired
    CandidateMapper candidateMapper;;

    @GetMapping("/candidate/{userId}/{accelerationId}/{companyId}")
    public ResponseEntity<CandidateDTO> findCandidate(@PathVariable Long userId, @PathVariable Long accelerationId, @PathVariable Long companyId) {

        return
                new ResponseEntity(
                        candidateService.findById(userId,accelerationId,companyId)
                                .map(candidateMapper::map)
                                .orElseThrow(() -> new ResourceNotFoundException("Candidate"))
                        , HttpStatus.OK
                );
    }


    @GetMapping("/candidate")
    public ResponseEntity<List<CandidateDTO>> findAllCandidate(@RequestParam(value = "companyId", required = false) Optional<Long> companyId ,
                                                               @RequestParam(value = "accelerationId", required = false) Optional<Long> accelerationId) {


        return new ResponseEntity(
                candidateMapper
                        .map(companyId.map(candidateService::findByCompanyId)
                                .orElseGet(() -> candidateService.findByAccelerationId(accelerationId.get())))
                ,HttpStatus.OK);

    }




}
