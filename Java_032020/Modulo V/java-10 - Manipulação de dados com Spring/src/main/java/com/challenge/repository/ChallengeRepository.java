package com.challenge.repository;

import com.challenge.entity.Challenge;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChallengeRepository extends BaseRepository<Challenge, Long> {

    List<Challenge>  findByAccelerations_IdAndSubmissions_Id_User_Id(Long accelerationId,Long user);

    Challenge save(Challenge challenge);

}
