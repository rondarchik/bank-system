package com.victoria.app.core.service;

import com.victoria.app.core.model.Manager;
import com.victoria.app.core.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User save(User user);

    Optional<User> findByLogin(String username);

    Optional<User> findById(long id);

    List<User> getAllNonActiveUserClientsForManager(Manager manager);

    List<User> getAll();
}
