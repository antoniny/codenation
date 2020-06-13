package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends BaseRepository<Company, Long> {

    Optional<Company> findById(Long id);

    List<Company> findDistinctByCandidates_Id_Acceleration_Id(Long id);

    List<Company> findDistinctByCandidates_Id_User_Id(Long userId);

    Company save(Company company);


}
