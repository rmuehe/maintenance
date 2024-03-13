package com.app.maintenance.service;

import com.app.maintenance.model.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {
    User saveUser(User user);
    Optional<User> getUser(Long id);
    List<User> getAllUsers();
    void deleteUser(Long id);
    User updateUser(User user);
}
