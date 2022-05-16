package com.victoria.app.core.service.impl;

import com.victoria.app.core.model.Bank;
import com.victoria.app.core.model.Manager;
import com.victoria.app.core.model.User;
import com.victoria.app.core.repository.ManagerRepository;
import com.victoria.app.core.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public List<Manager> findAll() {
        return managerRepository.findAll();
    }

    @Override
    public Optional<Manager> findByUser(User user) {
        return managerRepository.findByUser(user);
    }

    @Override
    public List<Manager> findByBank(Bank bank) {
        return managerRepository.findByBank(bank);
    }
}
