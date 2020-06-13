package com.challenge.service;

import com.challenge.entity.User;
import com.challenge.repository.UserRepository;
import com.challenge.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    UserRepository userRepository;


    @Override
    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public List<User> findByAccelerationName(String name) {
        return userRepository.findByCandidates_Id_Acceleration_NameIgnoreCase(name);
    }

    @Override
    public List<User> findByCompanyId(Long companyId) {
        return  userRepository.findByCandidates_Id_Company_Id(companyId);
    }

    @Override
    public User save(User user) {
        user.setCreatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }
}
