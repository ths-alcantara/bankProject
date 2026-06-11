package com.thais.bankProject.service.impl;

import com.thais.bankProject.domain.model.User;
import com.thais.bankProject.domain.repository.UserRepository;
import com.thais.bankProject.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User newUser) {
        if (userRepository.existsByAccountNumber(newUser.getAccount().getNumber())){
            throw new IllegalArgumentException("Essa conta já existe no sistema.");
        }
        return userRepository.save(newUser);
    }
}
