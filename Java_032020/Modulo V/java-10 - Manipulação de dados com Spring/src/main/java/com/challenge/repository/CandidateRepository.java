package com.challenge.repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateRepository extends BaseRepository<Candidate, Long> {


    Optional<Candidate> findById(CandidateId id);

    Optional<Candidate> findById_User_IdAndId_Company_IdAndId_Acceleration_Id(Long userId, Long companyId, Long accelerationId);

    List<Candidate>  findById_CompanyId(Long companyId);

    List<Candidate> findById_AccelerationId(Long accelerationId);

    Candidate save(Candidate candidate);

}
