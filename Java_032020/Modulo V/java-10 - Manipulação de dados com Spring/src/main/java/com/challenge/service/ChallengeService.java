package com.challenge.service;

import com.challenge.entity.Challenge;
import com.challenge.repository.ChallengeRepository;
import com.challenge.service.interfaces.ChallengeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChallengeService implements ChallengeServiceInterface {

    @Autowired
    ChallengeRepository challengeRepository;

    @Override
    public List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId) {
        return challengeRepository.findByAccelerations_IdAndSubmissions_Id_User_Id(accelerationId, userId);
    }

    @Override
    public Challenge save(Challenge challenge) {
        challenge.setCreatedAt(LocalDateTime.now());
        return challengeRepository.save(challenge);
    }
}
