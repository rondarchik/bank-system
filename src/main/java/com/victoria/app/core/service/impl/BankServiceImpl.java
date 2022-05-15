package com.victoria.app.core.service.impl;

import com.victoria.app.core.model.Bank;
import com.victoria.app.core.model.Client;
import com.victoria.app.core.repository.BankRepository;
import com.victoria.app.core.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private BankRepository bankRepository;

    @Override
    public List<Bank> findAll() {
        return bankRepository.findAll();
    }

    @Override
    public Bank getBankByName(String name) {
        return bankRepository.getBankByName(name);
    }

    @Override
    public List<Bank> getAllForClient(Client client) {
        return bankRepository.findAll().stream().filter(bank -> bank.getClients().contains(client)).collect(Collectors.toList());
    }


}
