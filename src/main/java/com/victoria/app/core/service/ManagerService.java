package com.victoria.app.core.service;

import com.victoria.app.core.model.Bank;
import com.victoria.app.core.model.Manager;
import com.victoria.app.core.model.User;

import java.util.List;
import java.util.Optional;

public interface ManagerService {

    List<Manager> findAll();

    Optional<Manager> findByUser(User user);

    List<Manager> findByBank(Bank bank);
}
