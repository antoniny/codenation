package com.challenge.service;

import com.challenge.entity.Submission;
import com.challenge.repository.SubmissionRepository;
import com.challenge.service.interfaces.SubmissionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SubmissionService implements SubmissionServiceInterface {

    @Autowired
    SubmissionRepository submissionRepository;

    @Override
    public BigDecimal findHigherScoreByChallengeId(Long challengeId) {

        Submission submission = submissionRepository.findFirstById_ChallengeIdOrderByScoreDesc(challengeId);

        return  (submission == null )
                ? BigDecimal.ZERO
                : BigDecimal.valueOf(submission.getScore());
    }

    @Override
    public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {
        return submissionRepository.findById_ChallengeId_Accelerations_Id(challengeId,accelerationId);
    }

    @Override
    public Submission save(Submission submission) {
        submission.setCreatedAt(LocalDateTime.now());
        return submissionRepository.save(submission);
    }
}
