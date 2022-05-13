package com.victoria.app.core.service.impl;

import com.victoria.app.core.exceptions.UserAlreadyExistsException;
import com.victoria.app.core.model.User;
import com.victoria.app.core.repository.UserRepository;
import com.victoria.app.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        boolean isUserNew = user.getId() == null;
        User oldUser = userRepository.findByLogin(user.getLogin()).orElse(null);

        if (oldUser != null && (isUserNew || !oldUser.getId().equals(user.getId()))) {
            throw new UserAlreadyExistsException();
        }

        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByLogin(String username) {
        return userRepository.findByLogin(username);
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }
}
