package com.thais.bankProject.service;

import com.thais.bankProject.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User newUser);
}
