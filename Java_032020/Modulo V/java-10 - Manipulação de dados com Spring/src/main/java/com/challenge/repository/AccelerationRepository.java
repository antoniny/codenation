package com.challenge.repository;

import com.challenge.entity.Acceleration;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccelerationRepository extends BaseRepository<Acceleration, Long> {

    Optional<Acceleration> findById(Long id);

    List<Acceleration> findByCandidates_Id_CompanyId(Long companyId);

    Optional<Acceleration> findByNameIgnoreCase(String nomeAcceleration);

    Acceleration save(Acceleration obj);

}
