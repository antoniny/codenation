package com.challenge.repository;

import com.challenge.entity.Submission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubmissionRepository extends BaseRepository<Submission, Long> {

    Submission findFirstById_ChallengeIdOrderByScoreDesc(Long limit);

    @Query("SELECT s FROM Submission s , Challenge c, Acceleration a where s.id.challenge.id = c.id and c.id = a.challenge.id and c.id = :idChallenge and a.id = :idAcceleration ")
    List<Submission> findById_ChallengeId_Accelerations_Id(@Param("idChallenge") Long idChallenge, @Param("idAcceleration") Long idAcceleration);

    @Override
    Submission save(Submission submission);


}
