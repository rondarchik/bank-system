package com.victoria.app.core.service.impl;

import com.victoria.app.core.exceptions.UserAlreadyExistsException;
import com.victoria.app.core.model.Client;
import com.victoria.app.core.model.Manager;
import com.victoria.app.core.model.Role;
import com.victoria.app.core.model.User;
import com.victoria.app.core.repository.ClientRepository;
import com.victoria.app.core.repository.UserRepository;
import com.victoria.app.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User save(User user) {
        boolean isUserNew = user.getId() == null;
        User oldUser = userRepository.findByLogin(user.getLogin()).orElse(null);

        if (oldUser != null && (isUserNew || !oldUser.getId().equals(user.getId()))) {
            throw new UserAlreadyExistsException();
        }

        if (isUserNew) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
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

    @Override
    public List<User> getAllNonActiveUserClientsForManager(Manager manager) {
        List<User> nonActiveUsers = userRepository.findAll()
                .stream()
                .filter(u -> !u.isActive())
                .filter(u -> u.getRole().equals(Role.CLIENT))
                .collect(Collectors.toList());

        List<Client> nonActiveClients = nonActiveUsers
                .stream()
                .map(user -> clientRepository.getClientByUser(user))
                .filter(client -> client.getBanks().contains(manager.getBank()))
                .collect(Collectors.toList());

        return nonActiveClients.stream().map(client -> findById(client.getUser().getId()).get()).collect(Collectors.toList());
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
