package com.challenge.service;

import com.challenge.entity.Company;
import com.challenge.repository.CompanyRepository;
import com.challenge.service.interfaces.CompanyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService implements CompanyServiceInterface {

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public List<Company> findByAccelerationId(Long accelerationId) {
        return companyRepository.findDistinctByCandidates_Id_Acceleration_Id(accelerationId);
    }

    @Override
    public List<Company> findByUserId(Long userId) {
        return companyRepository.findDistinctByCandidates_Id_User_Id(userId);
    }

    @Override
    public Company save(Company company) {
        company.setCreatedAt(LocalDateTime.now());
        return companyRepository.save(company);
    }
}
